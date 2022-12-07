import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][2];
        dp[0][0] = dp[0][1] = data[0];
        int result = data[0];
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(data[i], dp[i-1][0] + data[i]);
            dp[i][1] = Math.max(dp[i-1][1] + data[i], dp[i-1][0]);
            result = Math.max(result, Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(result);
        in.close();
    }

}