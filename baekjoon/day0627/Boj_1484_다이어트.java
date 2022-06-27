package baekjoon.day0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_1484_다이어트 {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(in.readLine());
		int a = 1; // 현재 무게
		int b = 1; // 과거 무게
		List<Integer> answers = new ArrayList<Integer>();
		while (a >= b && a <= 100000) {
			int diff = a * a - b * b;
			if (diff == G)
				answers.add(a);
			if (diff < G)
				a++;
			else
				b++;
		}
		if (!answers.isEmpty()) {
			for (int num : answers)
				System.out.println(num);
		} else
			System.out.println(-1);
		in.close();
	}
}
