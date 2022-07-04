package baekjoon.day0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_2108_통계학 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int data[] = new int[N];
		int sum = 0;
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(in.readLine());
			counter.put(data[i], counter.getOrDefault(data[i], 0) + 1);
			sum += data[i];
		}
		int avg = (int) Math.round((double) sum / N);
		Arrays.sort(data);
		int cnt = 0;
		List<Integer> mostList = new ArrayList<Integer>();
		for(int key : counter.keySet()) {
			if(counter.get(key) >= cnt) {
				if(cnt == counter.get(key)) {
					mostList.add(key);
				}else {
					cnt = counter.get(key);
					mostList.clear();
					mostList.add(key);
				}
			}
		}
		Collections.sort(mostList);
		int mostVal = 0;
		if(mostList.size() >= 2) 
			mostVal = mostList.get(1);
		else
			mostVal = mostList.get(0);
		System.out.println(avg);
		System.out.println(data[N/2]);
		System.out.println(mostVal);
		System.out.println(data[N-1] - data[0]);
		in.close();
	}
}
