package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1463_1로만들기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for(int i = 2; i <= n ; i++) {
			int min = Integer.MAX_VALUE;
			if(i % 2 == 0) min = Math.min(min, dp[i/2]+1);
			if(i % 3 == 0) min = Math.min(min, dp[i/3]+1);
			min = Math.min(min, dp[i-1]+1);
			dp[i] = min;
		}
		System.out.println(dp[n]);
		in.close();
	}
	
}
