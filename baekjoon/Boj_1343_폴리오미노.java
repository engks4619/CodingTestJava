package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Boj_1343_폴리오미노 {
	
	static ArrayDeque<String> q = new ArrayDeque<>();
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();
		count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = data.length()-1; i >= 0; i--) {
			if(data.charAt(i) == 'X') {
				count++;
			}else if(data.charAt(i) == '.'){
				convert();
				q.offer(".");
				count = 0;
			}
		}
		convert();
		if(count<=0) {
			while(!q.isEmpty())
				sb.append(q.pollLast());
			System.out.println(sb);
		}
		else System.out.println(-1);
		in.close();
	}
	
	static void convert() {
		while(count > 0) {
			if(count == 1) {
				System.out.println(-1);
				System.exit(0);
			}
			if(count % 4 == 0) {
				for(int j = 0; j < count / 4; j++)
					q.offer("AAAA");
				count = 0;
				break;
			}
			count -= 2;
			q.offer("BB");						
			
		}
	}
}
