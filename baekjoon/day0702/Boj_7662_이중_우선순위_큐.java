package baekjoon.day0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_7662_이중_우선순위_큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			TreeMap<Integer, Integer> treemap = new TreeMap<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				char oper = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());
				if(oper == 'I') {
					treemap.put(val, treemap.getOrDefault(val, 0) + 1);
				}else {
					if(treemap.isEmpty()) continue;
					if(val == -1) {
						int min = treemap.firstKey();
						if(treemap.get(min) == 1) 
							treemap.remove(min);
						else
							treemap.put(min, treemap.get(min) - 1);
					}else {
						int max = treemap.lastKey();
						if(treemap.get(max) == 1) 
							treemap.remove(max);
						else
							treemap.put(max, treemap.get(max) - 1);
					}
						
				}
			}
			if(treemap.isEmpty()) {
				sb.append("EMPTY");
			}else {
				sb.append(treemap.lastKey()).append(" ").append(treemap.firstKey());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		in.close();
	}
}
