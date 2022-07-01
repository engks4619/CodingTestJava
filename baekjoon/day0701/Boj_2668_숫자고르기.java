package baekjoon.day0701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj_2668_숫자고르기 {
	
	static int N, data[];
	static Set<Integer> result = new HashSet<Integer>();
	static Set<Integer> tmp = new HashSet<Integer>();
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		data = new int[N + 1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			go(i, i);	
			visited[i] = false;
			tmp.clear();
		}
		System.out.println(result.size());
		for(int i = 1; i <= N; i++) {
			if(result.contains(i))
				System.out.println(i);
		}
		in.close();
	}
	
	static void go(int start, int curr) {
		int next = data[curr];
		tmp.add(curr);
		tmp.add(next);
		if(next == start) {
			for(int num : tmp) 
				result.add(num);			
			return;
		}		
		if(visited[next]) return;
		visited[next] = true;
		go(start, next);
		visited[next] = false;		
		
	}
}
