package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11057_오르막수 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[][] dp = new long[1001][10];
		for(int i = 0 ; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k] % 10007;					
				}
			}
		}
		long result = 0;
		for(int i = 0; i <= 9; i++) {
			result += dp[N][i] % 10007;
		}
		System.out.println(result % 10007);
		in.close();
	}
}
