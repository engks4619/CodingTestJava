import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] distance;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        distance = new int[N][M];

        int sR = 0, sC = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                   sR = i;
                   sC = j;
                   board[sR][sC] = 0;
                }
            }
        }
        go(sR, sC);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(distance[i][j] == 0 && board[i][j] != 0 ? -1 : distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        in.close();
    }

    static void go(int sR, int sC){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[] {sR, sC});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            visited[r][c] = true;
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 0 || visited[nr][nc]) continue;
                distance[nr][nc] += distance[r][c] + 1;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
        return;
    }
}