package baekjoon.day0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1389_케빈_베이컨의_6단계_법칙 {
	
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adjMatrix = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(adjMatrix[i], INF);
		}
		while(M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(i == k) continue;
				for(int j = 1; j <= N; j++) {
					if(i == j || j == k) continue;
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
				}
			}
		}
		
		int result = INF;
		int answer = -1;
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				sum += adjMatrix[i][j];
			}
			if(result > sum) {
				result = sum;
				answer = i;
			}
		}
		System.out.println(answer);
		in.close();
	}
}
