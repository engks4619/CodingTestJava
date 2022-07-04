package baekjoon.day0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_17425_약수의_합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		final int MAX = 1000001;
		long[] f = new long[MAX];
		long[] dp = new long[MAX];
		Arrays.fill(f, 1);
		for (int i = 2; i < MAX; i++) {
			for (int j = 1; i * j < MAX; j++) {
				f[i * j] += i;
			}
		}
		for (int i = 1; i < MAX; i++) {
			dp[i] = dp[i - 1] + f[i];
		}
		while (N-- > 0) {
			int num = Integer.parseInt(in.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb.toString());
		in.close();
	}
}
