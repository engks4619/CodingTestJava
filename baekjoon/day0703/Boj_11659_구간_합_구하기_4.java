package baekjoon.day0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659_구간_합_구하기_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] data = new int[N+1];
		int[] sums = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sums[i] = sums[i-1] + data[i];
		}
		while(M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sums[j] - sums[i-1]).append("\n");
		}
		System.out.println(sb.toString());
		in.close();
	}
}
