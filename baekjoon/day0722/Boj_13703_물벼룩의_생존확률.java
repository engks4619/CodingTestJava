package baekjoon.day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13703_물벼룩의_생존확률 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[][] dp = new long[64][127]; // dp[N][2N]
		if (K == 0) {
			System.out.println(0);
			return;
		}
		dp[1][N] = 0;
		dp[1][N - 1] = 1;
		if (N + 1 < N + K) {
			dp[1][N + 1] = 1;
		} else {
			dp[1][N + 1] = 0;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < N + K; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				} else {
					if (j + 1 < N + K) {
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
					} else {
						dp[i][j] = dp[i - 1][j - 1];
					}
				}

			}
		}
		long result = 0;
		for (int i = 0; i < N + K; i++) {
			result += dp[N][i];
		}
		System.out.println(result);
		in.close();
	}
}
