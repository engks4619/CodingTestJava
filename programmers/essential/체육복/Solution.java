package programmers.essential.체육복;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] state = new int[n];
		for (int i : reserve) {
			state[i - 1]++;
		}
		for (int i : lost) {
			state[i - 1]--;
		}

		for (int i = 0; i < n; i++) {
			if (state[i] < 0) {
				if (i-1 >= 0 && state[i-1] > 0) {
					state[i]++;
					state[i-1]--;
				}else if(i+1 < n && state[i+1] > 0) {
					state[i]++;
					state[i+1]--;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (state[i] >= 0) {
				answer++;
			}
		}

		return answer;
	}
}