package baekjoon.day0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1461_도서관 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		List<Integer> minus = new ArrayList<Integer>();
		List<Integer> plus = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < 0) {
				minus.add(num);
			} else {
				plus.add(num);
			}
		}
		Collections.sort(minus);
		Collections.sort(plus);
		
		int maxValue = 0;
		int sum = 0;
		for (int i = 0; i < minus.size(); i += M) {
			maxValue = Math.max(maxValue, Math.abs(minus.get(i)));
			sum += Math.abs(minus.get(i)) * 2;
		}
		for (int i = plus.size() - 1; i >= 0; i -= M) {
			maxValue = Math.max(maxValue, plus.get(i));
			sum += plus.get(i) * 2;
		}
		sum -= maxValue;
		System.out.println(sum);
		in.close();
	}
}
