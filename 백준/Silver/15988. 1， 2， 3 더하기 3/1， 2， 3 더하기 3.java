import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int DIVIDER = (int)1e9 + 9;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        long[] dp = new long[(int)1e6 + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % DIVIDER;
        }
        while(T-- > 0){
            int N = Integer.parseInt(in.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}