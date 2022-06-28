package baekjoon.day0628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1105_팔 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String L = st.nextToken();
		String R = st.nextToken();
		
		if(L.length() != R.length()) {
			System.out.println(0);
			return;
		}
		int result = 0;
		for(int i = 0; i < L.length(); i++) {
			if(L.charAt(i) != R.charAt(i)) 
				break;			
			
			if(L.charAt(i) == R.charAt(i) && L.charAt(i) == '8')
				result++;
		}
		System.out.println(result);
		in.close();
	}
}
