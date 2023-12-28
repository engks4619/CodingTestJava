import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] lDp = getLeftStartDp();
        int[] rDp = getRightStartDp();
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lDp[i] + rDp[i] - 1);
        }
        System.out.println(max);
        in.close();
    }

    static int[] getLeftStartDp(){
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    static int[] getRightStartDp(){
        int[] dp = new int[N];
        dp[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
}