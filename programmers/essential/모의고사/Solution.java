package programmers.essential.모의고사;

import java.util.ArrayList;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] score = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (p1[i % p1.length] == answers[i])
				score[0]++;
			if (p2[i % p2.length] == answers[i])
				score[1]++;
			if (p3[i % p3.length] == answers[i])
				score[2]++;
		}
		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (max < score[i])
				max = score[i];
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			if (max == score[i - 1])
				list.add(i);
		}

		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}