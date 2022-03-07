package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			Stack<Character> lstack = new Stack<>();
			Stack<Character> rstack = new Stack<>();
			String msg = in.readLine();
			for (int i = 0; i < msg.length(); i++) {
				char c = msg.charAt(i);
				switch (c) {
				case '-':
					if(!lstack.isEmpty())
						lstack.pop();
					break;
				case '<':
					if (!lstack.isEmpty()) 
						rstack.push(lstack.pop());
					break;
				case '>':
					if (!rstack.isEmpty()) 
						lstack.push(rstack.pop());
					break;
				default:
					lstack.push(c);
					break;
				}
			}
			while (!rstack.isEmpty()) 
				lstack.push(rstack.pop());
			for (char c : lstack) 
				sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}

}
