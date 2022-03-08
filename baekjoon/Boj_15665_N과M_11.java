package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15665_N과M_11 {
	
	static int N, M;
	static int[] selected;
	static Integer[] data;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		N = set.size();
		data = set.toArray(new Integer[N]);
		Arrays.sort(data);
		selected = new int[M];
		dupPermutation(0);
		System.out.println(sb.toString());
		in.close();
	}
	
	static void dupPermutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			selected[cnt] = data[i];
			dupPermutation(cnt+1);
		}
	}
	
}
