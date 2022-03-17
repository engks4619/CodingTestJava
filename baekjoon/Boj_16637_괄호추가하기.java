package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_16637_괄호추가하기 {
	static int N, result;
	static List<Integer> numList;
	static List<Character> opList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		result = Integer.MIN_VALUE;
		numList = new ArrayList<>();
		opList = new ArrayList<>();
		String data = in.readLine();
		for (int i = 0; i < N; i++) {
			if (i % 2 != 0)
				opList.add(data.charAt(i));
			else
				numList.add(data.charAt(i) - '0');
		}
		dfs(0,numList.get(0));
		System.out.println(result);
		in.close();
	}
	
	static void dfs(int cnt, int sum) {
		if(cnt == opList.size()) {
			result = Math.max(result, sum);
			return;
		}
		//괄호 추가 X
		int num1 = calculate(opList.get(cnt), sum, numList.get(cnt+1));
		dfs(cnt+1,num1);
		//괄호 추가
		if(cnt >= opList.size()-1) return; // 마지막 연산자라 다다음 수가 없는 경우
		int temp = calculate(opList.get(cnt+1), numList.get(cnt+1), numList.get(cnt+2));
		int num2 = calculate(opList.get(cnt), sum, temp);
		dfs(cnt+2, num2);
	}
	
	static int calculate(char op, int a, int b) {
		switch(op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		default:
			return 0;
		}
	}
}
