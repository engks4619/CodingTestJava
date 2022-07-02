package baekjoon.day0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_11279_최대힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(pq.isEmpty()) 
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			}else
				pq.offer(num);
		}
		System.out.println(sb.toString());
		in.close();
	}
}
