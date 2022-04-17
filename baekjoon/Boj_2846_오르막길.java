package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i = 0; i < N-1; i++) {
			int sum = 0;
			int idx = i + 1;
			while(idx < N) {
				if(data[idx] <= data[idx-1])
					break;
				sum += data[idx] - data[idx-1];
				idx++;
			}
			result = Math.max(result, sum);
			i = idx-1;
		}
		System.out.println(result);
		in.close();
	}
}
