package baekjoon.day0628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2118_두_개의_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] data = new int[N+1];
		int total = 0;
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(in.readLine());
			total += data[i];
		}
		int result = 0;
		for (int a = 0; a < N; a++) {
			int sum = 0;
			for (int b = a + 1; b <= N; b++) {
				sum += data[b];
				int dist = Math.min(sum, total-sum);
				result = Math.max(result, dist);
			}
		}
		System.out.println(result);
		in.close();
	}
}
