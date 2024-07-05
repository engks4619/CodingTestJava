import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[15][15];
        for (int i = 0; i < 15; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        int TC = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(TC-- > 0){
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            sb.append(dp[K][N]).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}