import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] dp = new int[10001][3];
        dp[0][1] = Integer.parseInt(in.readLine());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + num;
            dp[i][2] = dp[i - 1][1] + num;
        }
        System.out.println(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
        in.close();
    }
}