import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N, M;
	// 0:상, 1:하, 2:좌, 3:우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][][] dir = { 
			{ },
			{ {0}, {1}, {2}, {3} },
			{ {0,1}, {2,3} },
			{ {0,3}, {3,1}, {1,2}, {2,0} },
			{ {2,0,3}, {0,3,1}, {3,1,2}, {1,2,0} },
			{ {0,1,2,3} } 
			};		
	
	static int minCount;
	static List<CCTV> cctvList;
	static int cctvCount;
	static boolean[] isSelected;
	
	
	static class CCTV {
		int r, c, number;

		public CCTV(int r, int c, int number) {
			super();
			this.r = r;
			this.c = c;
			this.number = number;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minCount = Integer.MAX_VALUE;
		board = new int[N][M];
		cctvList = new ArrayList<>();
		int blank = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= board[i][j] && board[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, board[i][j]));
				}
				if(board[i][j] == 0) blank++;
			}
		}
		cctvCount = cctvList.size();
		isSelected = new boolean[cctvCount];		
		
		recursive(0, blank, board);
		
		System.out.println(minCount);
		in.close();
	}
	
	static void recursive(int cnt, int currBlind, int[][] currBoard) {
		if(cnt == cctvCount) {
			minCount = Math.min(minCount, currBlind);
			return;
		}
		int[][] newBoard = new int[N][M];
		CCTV cctv = cctvList.get(cnt);		
		for(int i = 0; i < dir[cctv.number].length; i++) {
			copyBoard(newBoard, currBoard);
			int inspected = 0;
			for (int j = 0; j < dir[cctv.number][i].length; j++) {
				int direction = dir[cctv.number][i][j];
				inspected += inspect(cctv.r, cctv.c, direction, newBoard);
			}
			recursive(cnt+1, currBlind - inspected, newBoard);
		}
	}

	static int inspect(int r, int c, int d, int[][] tempBoard) {	
		int count = 0;
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			// 영역 밖이거나 벽에 막히면 현재까지 카운트 반환
			if(nr < 0 || nr>= N || nc < 0 || nc >= M || board[nr][nc] == 6) {
				return count;
			}
			// CCTV가 존재하는 위치거나 이미 감시한 영역이면 건너뛰기
			if((1 <= board[nr][nc] && board[nr][nc] <= 5)|| tempBoard[nr][nc] == -1) continue;
			// 감시했음을 -1로 표시
			tempBoard[nr][nc] = -1;
			count++;
		}				
	}

	static void copyBoard(int[][] newBoard, int[][] targetBoard) {
		for (int i = 0; i < N; i++) {
			newBoard[i] = targetBoard[i].clone();
		}
	}

}