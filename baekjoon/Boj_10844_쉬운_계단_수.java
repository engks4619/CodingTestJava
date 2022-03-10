package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10844_쉬운_계단_수 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[][] dp = new long[N + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][0] = dp[i - 1][1];
				else if (j == 9)
					dp[i][9] = dp[i - 1][8];
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
			}
		}
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		System.out.println(result % 1000000000);
		in.close();
	}

}
