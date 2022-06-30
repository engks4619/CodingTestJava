package baekjoon.day0630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1927_최소_힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(pq.size() > 0)
					sb.append(pq.poll());
				else
					sb.append(0);
				sb.append("\n");
			}else {				
				pq.offer(num);
			}
		}
		System.out.println(sb.toString());
		in.close();
	}
	
}
