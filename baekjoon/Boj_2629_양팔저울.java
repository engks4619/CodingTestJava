package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2629_양팔저울 {
	
	static int N, choos[];
	static boolean[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		N = Integer.parseInt(in.readLine()); 
		choos = new int[N];
		dp = new boolean[N+1][15001];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) { 
			choos[i] = Integer.parseInt(st.nextToken()); 
		}
		dfs(0,0);
		int M = Integer.parseInt(in.readLine()); 
		st = new StringTokenizer(in.readLine()); 
		for(int i = 0; i < M; i++) {
			int ball = Integer.parseInt(st.nextToken());
			if(ball > 15000)
				sb.append("N");
			else if(dp[N][ball])
				sb.append("Y");
			else
				sb.append("N");
			sb.append(" ");
		}
		System.out.println(sb);
		in.close();
	}
	
	static void dfs(int idx, int weight) {
		if(dp[idx][weight]) return;		
		dp[idx][weight] = true;
		if(idx == N) return;		
		
		dfs(idx+1, weight+choos[idx]);
		dfs(idx+1, weight);
		dfs(idx+1, Math.abs(weight-choos[idx]));
	}
}
