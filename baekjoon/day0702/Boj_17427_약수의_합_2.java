package baekjoon.day0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_17427_약수의_합_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long sum = 0;
		for (int i = 1; i <= N; i++)
			sum += (N / i) * i;
		System.out.println(sum);
		in.close();
	}
}
