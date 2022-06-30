package baekjoon.day0630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_10453_문자열_변환 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			int result = 0;
			String[] tmp = in.readLine().split(" ");
			String A = tmp[0];
			String B = tmp[1];
			List<Integer> listA = new ArrayList<Integer>();
			List<Integer> listB = new ArrayList<Integer>();
			for(int i = 0; i < A.length(); i++) {
				if(A.charAt(i) == 'b')
					listA.add(i);
				if(B.charAt(i) == 'b')
					listB.add(i);
			}
			for(int i = 0; i < listA.size(); i++) {
				result += Math.abs(listA.get(i) - listB.get(i));
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		in.close();
	}
}
