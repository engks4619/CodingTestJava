import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = { -1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, result, board[][], dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result, go(i, j));
            }
        }
        System.out.println(result);
        in.close();
    }

    public static int go(int r, int c) {
        if(dp[r][c] != 1)
            return dp[r][c];

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] <= board[r][c])
                continue;
            dp[r][c] = Math.max(dp[r][c], go(nr, nc) + 1);
        }
        return dp[r][c];
    }
}