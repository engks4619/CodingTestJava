package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_13164_행복유치원 {
	
	static int N, K, diff[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		diff = new int[N-1];
		for(int i = 0; i < N-1; i++) {
			diff[i] = data[i+1] - data[i];
		}
		Arrays.sort(diff);
		int sum = 0;
		for(int i = 0; i < N-K; i++) {
			sum += diff[i];
		}
		System.out.println(sum);
		in.close();
	}
	

	
}
