package baekjoon.day0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		outer: for(int tc = 0; tc < T; tc++) {
			String oper = in.readLine();
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(),"[,]");
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			boolean front = true;
			boolean error = false;
			for(char op : oper.toCharArray()) {
				switch(op) {
				case 'R':
					front = !front;
					break;
				case 'D':
					if(queue.isEmpty()) {
						sb.append("error").append("\n");
						error = true;
						continue outer;
					}
					if(front) 
						queue.pollFirst();
					else 
						queue.pollLast();					
					break;
				}
			}
			
			sb.append("[");
			while(!queue.isEmpty()) {
				if(front) 
					sb.append(queue.pollFirst());
				else 
					sb.append(queue.pollLast());	
				
				if(!queue.isEmpty()) 
					sb.append(",");	
			}
			sb.append("]\n");
		}
		System.out.println(sb);
		
	}
}
