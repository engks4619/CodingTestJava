import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX_ARR_SIZE = 100001;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[2][MAX_ARR_SIZE];
            int[][] dp = new int[2][MAX_ARR_SIZE];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = Math.max(dp[1][0] + arr[0][1], arr[0][1]);
            dp[1][1] = Math.max(dp[0][0] + arr[1][1], arr[1][1]);
            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(Math.max(dp[1][i - 1], dp[0][i - 2]), dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[0][i - 2]), dp[1][i - 2]) + arr[1][i];
            }
            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}