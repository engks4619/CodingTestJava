package baekjoon.day0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1263_시간_관리 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new Point(b-a, b));	
		}
		Point curr = pq.poll();
		int a = curr.a;
		int b = curr.b;
		while(!pq.isEmpty()) {
			Point next = pq.poll();
			int c = next.a;
			int d = next.b;
			if(a <= d) {
				a = a-(d-c);
				b = a;				
			}else {
				a = c;
				b = d;
			}
		}
		System.out.println(a < 0 ? -1 : a);
		in.close();
	}
	
	public static class Point implements Comparable<Point>{
		int a, b;
		
		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Point o) {
			return this.b != o.b ? o.b-this.b : o.a - this.a;
		}

		@Override
		public String toString() {
			return "Point [a=" + a + ", b=" + b + "]";
		}
		
	}
}
