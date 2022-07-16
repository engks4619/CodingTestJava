package baekjoon.day0715;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class Boj_2922_즐거운_단어 {

	static long result = 0;
	static String S;
	static List<Character> moeum = new ArrayList<>();

	static void init() {
		moeum.add('A');
		moeum.add('E');
		moeum.add('I');
		moeum.add('O');
		moeum.add('U');
	}

	public static void main(String[] args) throws Exception {
		init();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = in.readLine();
		result = go(0, false, 0, 0);
		System.out.println(result);
		in.close();
	}

	static long go(int cnt, boolean checkL, int mCnt, int jCnt) {
		if (mCnt >= 3 || jCnt >= 3)
			return 0;
		while (cnt < S.length() && S.charAt(cnt) != '_') {
			char c = S.charAt(cnt);
			if (c == 'L')
				checkL = true;
			if (moeum.contains(c)) {
				jCnt = 0;
				mCnt++;
			} else {
				mCnt = 0;
				jCnt++;
			}
			if (mCnt >= 3 || jCnt >= 3)
				return 0;
			cnt++;
		}
		if (mCnt >= 3 || jCnt >= 3)
			return 0;
		if (cnt == S.length()) 
			return checkL ? 1 : 0;
		
		long sum = 0;
		if (cnt < S.length() && S.charAt(cnt) == '_') {
			sum += 5 * go(cnt + 1, checkL, mCnt + 1, 0); // 모음
			sum += 20 * go(cnt + 1, checkL, 0, jCnt + 1); // L제외 자음
			sum += go(cnt + 1, true, 0, jCnt + 1); // L
		}
		return sum;
	}
}
