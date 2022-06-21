package baekjoon.day0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_5904_Moo_게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int totalLength = 3;
		int midLength = 3;
		while(N > totalLength) {
			midLength++;
			totalLength = totalLength * 2 + midLength;
		}
		System.out.println(moo(N, totalLength, midLength));
		in.close();
	}
	
	static char moo(int n, int total, int mid) {
		if(n <= 3) {
			if(n == 1) return 'm';
			else return 'o';
		}
		
		int leftPoint = (total-mid) / 2 + 1;
		int rightPoint = (total-mid) / 2 + mid + 1;
		if(n < leftPoint) { // 왼쪽에 있는 경우
			return moo(n, leftPoint-1, mid-1);						
			
		}else if(leftPoint <= n && n < rightPoint) { // 중간에 있는 경우
			if(n == leftPoint) 
				return 'm';
			else
				return 'o';
	
		}else { // 오른쪽에 있는 경우
			return moo(n-(rightPoint-1), total-(rightPoint-1), mid-1);			
		}
	}

}
