package baekjoon.day0630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(in.readLine());
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			String name = in.readLine();
			if(set.contains(name)) 
				pq.offer(name);
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		in.close();
	}
}
