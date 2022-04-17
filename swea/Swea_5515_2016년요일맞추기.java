package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5515_2016년요일맞추기 {

	static int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1월부터 12월까지의 날짜 수
	static int[] yoil = { 3, 4, 5, 6, 0, 1, 2 }; // 1월 1일이 4(금요일)부터 시작하므로 인덱스에 각 요일 맞추기

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int day = 0; 
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for (int i = 1; i < m; i++) // 이전 월까지의 날짜 더 하기
				day += days[i];
			day += d; // 현재 월 날짜 더하기
			sb.append("#").append(tc).append(" ").append(yoil[day%7]).append("\n");
		}
		System.out.println(sb);
		in.close();
	}

}
