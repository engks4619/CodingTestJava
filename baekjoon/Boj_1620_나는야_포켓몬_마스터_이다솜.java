package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1620_나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> numberMap = new HashMap<Integer, String>();
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		for(int i = 1; i <= N; i++) {
			String name = in.readLine();
			numberMap.put(i, name);
			nameMap.put(name, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String s = in.readLine();
			if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
				sb.append(nameMap.get(s));
			}else {
				sb.append(numberMap.get(Integer.parseInt(s)));
			}
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}
}
