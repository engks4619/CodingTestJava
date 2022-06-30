package baekjoon.day0630;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10989_수_정렬하기_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] data = new int[10001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			data[num]++;
		}

		for (int i = 1; i <= 10000; i++) {
			if (data[i] == 0)
				continue;
			for (int j = 0; j < data[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
		in.close();
	}
}
