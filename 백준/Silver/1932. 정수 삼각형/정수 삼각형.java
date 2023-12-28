import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                    continue;
                }
                if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        System.out.println(Arrays.stream(dp[N-1]).max().getAsInt());
        in.close();
    }
}