package baekjoon.day0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_18870_좌표_압축 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] data = new int[N];
		int[] sortedData = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		sortedData = data.clone();
		Arrays.sort(sortedData);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int val = 0;
		for(int num : sortedData) {
			if(!map.containsKey(num))
				map.put(num, val++);
		}
		StringBuilder sb = new StringBuilder();
		for(int num : data) {
			sb.append(map.get(num)).append(" ");
		}
		System.out.println(sb.substring(0, sb.length()-1).toString());
		in.close();
	}
}
