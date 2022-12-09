import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1000000003;
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int[][] dp = new int[1001][1001];

        for(int i = 1; i <= N; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i = 3; i <= N; i++){
            for(int j = 2; j <= (i + 1) / 2; j++){
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % MOD;
            }
        }
        System.out.println((dp[N-3][K-1]+ dp[N-1][K]) % MOD);
        in.close();
    }
}