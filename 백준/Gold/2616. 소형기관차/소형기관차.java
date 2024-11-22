import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(in.readLine());
        int[][] dp = new int[4][N + 1];
        for (int i = 1; i < 4; i++) {
            for (int j = i * M; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + sum[j] - sum[j - M]);
            }
        }
        System.out.println(dp[3][N]);
        in.close();
    }

}