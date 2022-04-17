package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_16463_13일의금요일 {

	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] yoil = { 0, 1, 2, 3, 4, 5, 6 }; // 0 : 월 ~ 6: 일 (2019년 1월 1일이 화요일이므로 1번 인덱스는 화요일)

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int count = 0;
		int d = 13; // 기본 13일로 세팅
		for (int y = 2019; y <= N; y++) { // 2019년부터 입력받은 연도 까지
			if (isYoonYear(y)) { // 윤년 체크
				days[2] = 29;
			} else {
				days[2] = 28;
			}
			for (int m = 1; m <= 12; m++) { // 1월부터 12월까지 확인
				if (yoil[d % 7] == 4) { // 금요일이면 count 증가
					count++;
				}
				d += days[m]; // 현재 월의 날짜 수만큼 더해주기
			}
		}
		System.out.println(count);
		in.close();
	}

	static boolean isYoonYear(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 100 == 0)
			return false;
		if (year % 4 == 0)
			return true;
		return false;
	}

}
