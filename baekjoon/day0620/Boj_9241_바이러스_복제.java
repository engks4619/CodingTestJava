package baekjoon.day0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9241_바이러스_복제 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String A = in.readLine();
		String B = in.readLine();
		
		int aCursor = 0;
		int bCursor = 0;
		int leftLength = 0;
		while (aCursor < A.length() && bCursor < B.length()) {
			if (A.charAt(aCursor) != B.charAt(bCursor)) {
				break;
			}
			aCursor++;
			bCursor++;
			leftLength++;
		}
		aCursor = A.length() - 1;
		bCursor = B.length() - 1;
		int rightLength = 0;
		while (aCursor >= leftLength && bCursor >= leftLength) {
			if (A.charAt(aCursor) != B.charAt(bCursor)) {
				break;
			}
			aCursor--;
			bCursor--;
			rightLength++;
		}
		int result = B.length() - leftLength - rightLength;
		System.out.println(result);
		in.close();
	}

}
