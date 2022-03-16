package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boj_12026_BOJ_거리 {
	
	static int N, dp[];
	static char[] arr;
	static Map<Character, Character> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int INF = (int)1e9;
		map = new HashMap<>();
		map.put('B', 'O');
		map.put('O', 'J');
		map.put('J', 'B');
		int N = Integer.parseInt(in.readLine());
		arr = in.readLine().toCharArray();
		dp = new int[N];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i = 0; i < N - 1; i++) {
			char curr = arr[i];
			char target = map.get(curr);
			for (int j = i + 1; j < N; j++) {
				if(arr[j] == target) {
					int dist = j - i;
					dp[j] = Math.min(dp[j], dp[i] + dist * dist);
				}
			}
		}		
		System.out.println(dp[N-1] == INF ? -1 : dp[N-1]);
		in.close();
	}
	
}
