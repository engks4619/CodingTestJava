import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = (int) 1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        int N = Integer.parseInt(in.readLine());
        long[][][] dp = new long[101][10][1<<10];
        for(int i = 1; i < 10; i++){
            dp[1][i][1<<i] = 1;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < (1 << 10); k++){
                    int next = k | (1 << j);
                    if(j != 0){
                        dp[i][j][next] = (dp[i][j][next] + dp[i-1][j-1][k]) % MOD;
                    }
                    if(j != 9){
                        dp[i][j][next] = (dp[i][j][next] + dp[i-1][j+1][k]) % MOD;
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++){
            result += dp[N][i][(1<<10)-1];
        }
        System.out.println(result % MOD);
        in.close();
    }
}