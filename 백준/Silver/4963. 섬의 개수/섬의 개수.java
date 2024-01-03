import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1, 1, -1, -1, 1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            board = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }
            int cnt = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visited[i][j] || !board[i][j]) continue;
                    bfs(i, j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(int sR, int sC){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC});
        visited[sR][sC] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc] || !board[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }

        }
    }
}