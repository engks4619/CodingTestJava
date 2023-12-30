import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int maxResult = 0;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                go(i, j, 1, board[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(maxResult);
        in.close();
    }

    static void go(int r, int c, int cnt, int sum){
        if(cnt == 4){
            maxResult = Math.max(maxResult, sum);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            go(nr, nc, cnt + 1, sum + board[nr][nc]);
            if(cnt == 2) go(r, c, cnt + 1, sum + board[nr][nc]);
            visited[nr][nc] = false;
        }

    }
}