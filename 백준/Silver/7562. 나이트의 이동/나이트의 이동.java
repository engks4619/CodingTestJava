import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int I;
    static boolean[][] visited;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(TC-- > 0){
            I = Integer.parseInt(in.readLine());
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(in.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());
            int minCnt = bfs(sR, sC, eR, eC);
            sb.append(minCnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static int bfs(int sR, int sC, int eR, int eC){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sR, sC, 0});
        visited[sR][sC] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            if(r == eR && c == eC){
                return cnt;
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= I || nc < 0 || nc >= I || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, cnt + 1});
            }
        }

        return -1;
    }
}