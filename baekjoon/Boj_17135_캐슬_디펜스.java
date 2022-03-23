package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17135_캐슬_디펜스 {

	static int N, M, D, board[][], maxCount;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		maxCount = 0;
		board = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[M];
		combi(0, 0);
		System.out.println(maxCount);
		in.close();
	}

	static void combi(int cnt, int start) {
		if (cnt == 3) {
			int[][] tempBoard = initBoard();
			int count = 0;			
			while (isEnemyExist(tempBoard)) { // 공격할 적이 없으면 끝
				boolean[][] attacked = new boolean[N][M];
				for (int posX = 0; posX < M; posX++) {
					if (isSelected[posX]) {
						int targetR = -1;
						int targetC = -1;
						int dist = Integer.MAX_VALUE;
						for (int i = 0; i < N; i++) {
							for (int j = 0; j < M; j++) {
								if (tempBoard[i][j] == 1) {
									int tempDist = Math.abs(N - i) + Math.abs(posX - j);
									if(tempDist <= D) {
										if(tempDist < dist) {
											dist = tempDist;
											targetR = i;
											targetC = j;													
										}else if(tempDist == dist && j < targetC) {
												targetR = i;
												targetC = j;
										}
									}
								}
							}
						}
						if (targetR == -1 || targetC == -1) continue; //해당 궁수가 공격할 수 있는 적이 없다면 넘어가기
						attacked[targetR][targetC] = true;
					}
				}
				// 공격한 적 수 카운트 및 공격당한 적 없애기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (attacked[i][j]) {
							tempBoard[i][j] = 0;
							count++;
						}
					}
				}
				// 한칸씩 내리기
				for (int i = N - 1; i > 0; i--) {
					tempBoard[i] = tempBoard[i-1].clone();
				}
				Arrays.fill(tempBoard[0], 0);
				
			}
			// 각 경우에 대해 죽인 적 수 최대값 갱신
			maxCount = Math.max(maxCount, count);
			return;
		}
		for (int i = start; i < M; i++) {
			isSelected[i] = true;
			combi(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	static int[][] initBoard() {
		int[][] tempBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempBoard[i][j] = board[i][j];
			}
		}
		return tempBoard;
	}
	
	static boolean isEnemyExist(int[][] tempBoard) {
		boolean flag = false;
		Outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempBoard[i][j] == 1) {
					flag = true;
					break Outer;
				}
			}
		}
		return flag;
	}
}