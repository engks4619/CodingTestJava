import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N + 1][K + 1];
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % (int) 1e9;
            }
        }
        System.out.println(dp[N][K]);
        in.close();
    }
}