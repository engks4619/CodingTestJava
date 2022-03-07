package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1747_소수and팰린드롬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		while(true) {
			if(isPrime(N) && isPalindrome(N)) 
				break;
			N++;
		}
		System.out.println(N);
	}
	
	static boolean isPrime(int n) {
		if(n <= 1) 
			return false;		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	static boolean isPalindrome(int n) {
		String num = Integer.toString(n);
		for(int i = 0; i < num.length()/2; i++) {
			if(num.charAt(i) != num.charAt(num.length()-1-i))
				return false;
		}
		return true;
	}
	
}
