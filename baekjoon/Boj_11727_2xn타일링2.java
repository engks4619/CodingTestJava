package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11727_2xn타일링2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int dp[] = new int[N+1];
		if(N <= 1) {
			System.out.println(N);
			in.close();
			return;
		}
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= N; i++) {
			dp[i] = (2*dp[i-2] + dp[i-1]) % 10007;
		}
		System.out.println(dp[N]);
		in.close();
	}
	
}
