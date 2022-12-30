import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] data, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        data = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            data[i][0] = r;
            data[i][1] = c;
        }
        dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        function(1, N);
        System.out.println(dp[1][N]);
        in.close();
    }

    public static int function(int s, int e) {
        if(s == e) return 0;

        if(dp[s][e] != Integer.MAX_VALUE)  return dp[s][e];

        for(int i = s; i < e; i++) {
            dp[s][e] = Math.min(dp[s][e], function(s, i) + function(i+1, e) + (data[s][0] * data[i][1] * data[e][1]));
        }

        return dp[s][e];
    }
}