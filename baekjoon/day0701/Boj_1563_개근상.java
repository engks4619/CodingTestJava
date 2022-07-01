package baekjoon.day0701;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1563_개근상 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][][] dp = new int[N+1][2][3]; // 일, 지각, 결석
		// 첫째 날 가능한 경우 초기화
		if(N == 0) {
			System.out.println(0);
			return;
		}
		dp[1][0][0] = 1; // 출석
		dp[1][1][0] = 1; // 지각
		dp[1][0][1] = 1; // 결석
		for(int i = 2; i <=N; i++) {
			dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % 1000000;
			dp[i][0][1] = dp[i-1][0][0] % 1000000;
			dp[i][0][2] = dp[i-1][0][1] % 1000000;
			dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2] + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) % 1000000;
			dp[i][1][1] = dp[i-1][1][0] % 1000000;
			dp[i][1][2] = dp[i-1][1][1] % 1000000;
		}
		int result = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				result += dp[N][i][j];
			}
		}
		System.out.println(result % 1000000);
		in.close();
	}
}
