package baekjoon.day0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16437_양_구출_작전 {
	
	static int N;
	static long dp[];
	static List<Integer> list[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		dp = new long[N+1];
		list = new ArrayList[N + 1];
		
		for(int i = 1 ; i <= N; i++) 
			list[i] = new ArrayList<>();
		
		StringTokenizer st = null;
		for(int i = 2; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			char type = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list[p].add(i);
			switch(type) {
			case 'S':
				dp[i] = a;
				break;
			case 'W':
				dp[i] = a * -1;
				break;
			}
		}
		dfs(1, 0);
		System.out.println(dp[1]);
		in.close();
	}
	
	static void dfs(int currIdx, int parentIdx) {
		for(int next : list[currIdx]) 
			dfs(next, currIdx);

		if (parentIdx == 0)
			return;

		if(dp[currIdx] > 0) 
			dp[parentIdx] += dp[currIdx];
				
	}
}
