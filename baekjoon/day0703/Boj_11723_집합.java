package baekjoon.day0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_11723_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String oper = st.nextToken();
			int val = 0;
			if(!oper.equals("all") && !oper.equals("empty")) 
				val = Integer.parseInt(st.nextToken());				
			switch(oper) {
			case "add":
				set.add(val);
				break;
			case "remove":
				set.remove(val);
				break;
			case "check":
				if(set.contains(val)) 
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
				break;
			case "toggle":
				if(set.contains(val))
					set.remove(val);
				else
					set.add(val);
				break;
			case "all":
				for(int num = 1; num <= 20; num++) 
					set.add(num);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb.toString());
		in.close();
	}
}
