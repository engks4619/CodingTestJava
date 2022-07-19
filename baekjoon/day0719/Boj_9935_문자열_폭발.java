package baekjoon.day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9935_문자열_폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String bomb = in.readLine();
		char lastChar = bomb.charAt(bomb.length() - 1);
		Stack<Character> st = new Stack<>();
		for (Character c : str.toCharArray()) {
			st.add(c);
			if (!st.isEmpty() && st.peek() == lastChar) {
				boolean flag = true;
				Stack<Character> tmpSt = new Stack<>();
				int curr = bomb.length() - 1;
				while (curr >= 0) {
					if (!st.isEmpty() && st.peek() == bomb.charAt(curr)) {
						tmpSt.add(st.pop());
					} else {
						flag = false;
					}
					curr--;
				}
				if (!flag && !tmpSt.isEmpty()) {
					while (!tmpSt.isEmpty()) {
						st.add(tmpSt.pop());
					}
				}
			}
		}
		if(st.isEmpty()) {
			System.out.println("FRULA");
			return;
		}else {			
			StringBuilder sb = new StringBuilder();
			while(!st.isEmpty()) 
				sb.append(st.pop());
			
			System.out.println(sb.reverse().toString());
		}
		in.close();
	}
}
