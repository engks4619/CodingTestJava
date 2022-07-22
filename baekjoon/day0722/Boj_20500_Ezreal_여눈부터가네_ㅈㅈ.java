package baekjoon.day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_20500_Ezreal_여눈부터가네_ㅈㅈ {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long MOD = 1000000007;
		long[][] dp = new long[1516][3];
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[2][2] = 0;
		for(int i = 3; i <= N; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
		}
		System.out.println(dp[N][0]);
		in.close();
	}
}
