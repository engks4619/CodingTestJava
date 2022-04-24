package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_15988_123더하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[1000001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= 1000000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
		}
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
		in.close();
	}
}
