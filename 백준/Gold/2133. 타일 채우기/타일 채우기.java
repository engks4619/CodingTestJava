import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= N; i++) {
            if(i % 2 != 0) {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j--) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[N]);
        in.close();
    }
}