package baekjoon.day0623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_22115_창영이와_커피 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] C = new int[N];
		int INF = (int) 1e9;
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[K+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i = N-1; i >= 0; i--) {
			int curr = C[i];
			for(int j = K; j >= curr; j--) {
				dp[j] = Math.min(dp[j], dp[j-curr] + 1);
			}
		}
		System.out.println(dp[K] == INF ? -1 : dp[K]);
		
		in.close();
	}
}
