package baekjoon.day0623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3151_합이_0 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] numbers = new int[N];
		long result = 0L;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		for (int i = 0; i < N; i++) {
			if (numbers[i] > 0)
				break;
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				int curr = numbers[i] + numbers[left] + numbers[right];
				int l = 1;
				int r = 1;
				if (curr == 0) {
					if (numbers[left] == numbers[right]) {
						int n = right - left + 1;
						result += n * (n - 1) / 2;
						break;
					}
					while (left + 1 < right && numbers[left] == numbers[left + 1]) {
						l++;
						left++;
					}
					while (right - 1 > left && numbers[right - 1] == numbers[right]) {
						r++;
						right--;
					}
					result += l * r;
				}
				if (curr > 0)
					right--;
				else
					left++;
			}
		}
		System.out.println(result);
		in.close();
	}
}
