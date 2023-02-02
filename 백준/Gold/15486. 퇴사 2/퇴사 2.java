import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] data = new int[N + 1][2];
        int[] dp = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            int next = i + data[i][0] - 1;
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i - 1] + data[i][1]);
            }
        }
        System.out.println(dp[N]);
        in.close();
    }
}