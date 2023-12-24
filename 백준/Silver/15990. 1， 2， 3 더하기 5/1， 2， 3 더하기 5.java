import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int DIVIDER = (int)1e9 + 9;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % DIVIDER;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % DIVIDER;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % DIVIDER;
        }
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int N = Integer.parseInt(in.readLine());
            long cnt = 0;
            for (int i = 1; i <= 3; i++) {
                cnt += dp[N][i];
            }
            sb.append(cnt % DIVIDER).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}