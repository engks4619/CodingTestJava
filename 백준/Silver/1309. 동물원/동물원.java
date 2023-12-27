import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int DIVIDER = 9901;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= N; i++) {
            dp[i] = (3 * dp[i - 2] + 2 * (dp[i - 1] - dp[i - 2])) % DIVIDER;
        }
        System.out.println(dp[N]);
        in.close();
    }
}