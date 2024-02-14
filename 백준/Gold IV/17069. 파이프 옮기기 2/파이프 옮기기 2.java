import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        boolean[][] board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        long[][][] dp = new long[N][N][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(board[i][j]) continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                if(i == 0) continue;
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                if(board[i][j - 1] || board[i - 1][j]) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        long totalCnt = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        bw.write(totalCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

}