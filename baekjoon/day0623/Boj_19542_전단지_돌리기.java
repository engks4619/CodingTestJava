package baekjoon.day0623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_19542_전단지_돌리기 {

	static List<Integer> list[];
	static int dp[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dp = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		dfs(S, -1);
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (i != S && dp[i] >= D)
				cnt++;
		}
		System.out.println((cnt) * 2);
		in.close();
	}

	static void dfs(int curr, int parent) {
		visited[curr] = true;

		for (int next : list[curr]) {
			if (!visited[next])
				dfs(next, curr);
		}

		if (parent == -1)
			return;

		dp[parent] = Math.max(dp[parent], dp[curr] + 1);

	}
}