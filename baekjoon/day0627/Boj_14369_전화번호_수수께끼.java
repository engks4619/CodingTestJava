package baekjoon.day0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_14369_전화번호_수수께끼 {
	
	static String[] dict = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
	static Map<Integer, Integer> result;
	static Map<Character, Integer> counter;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			result = new HashMap<>();
			counter = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (counter.containsKey(c))
					counter.put(c, counter.get(c) + 1);
				else
					counter.put(c, 1);
			}
			dfs(str.length(), new HashMap<>());		
			sb.append("Case #").append(tc).append(": ");
			for(int i = 0; i <= 9; i++) {
				if(!result.containsKey(i)) continue;
				for(int j = 0; j < result.get(i); j++) {
					sb.append(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		in.close();
	}
	
	static void dfs(int length, HashMap<Integer, Integer> tmp){
		if(length == 0) {
			result = (Map<Integer, Integer>) tmp.clone();
			return;
		}
		if(length < 0) {
			return;
		}
		for(int i = 0; i <= 9; i++) {
			Map<Character, Integer> ckCount = new HashMap<>();
			String str = dict[i];
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if(ckCount.containsKey(c))
					ckCount.put(c, ckCount.get(c) + 1);
				else
					ckCount.put(c, 1);
			}
			boolean flag = true;
			for(char c : ckCount.keySet()) {
				if(!counter.containsKey(c)) {
					flag = false;
					break;
				}
				if(counter.get(c) < ckCount.get(c)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(!tmp.containsKey(i)) 
					tmp.put(i, 0);				
				tmp.put(i, tmp.get(i) + 1);	
				
				for(char c : ckCount.keySet()) 
					counter.put(c, counter.get(c) - ckCount.get(c));
				
				dfs(length - str.length(), tmp);
				
				for(char c : ckCount.keySet())
					counter.put(c, counter.get(c) + ckCount.get(c));
				
				tmp.put(i, tmp.get(i) - 1);
			}
		}
		
	}
}
