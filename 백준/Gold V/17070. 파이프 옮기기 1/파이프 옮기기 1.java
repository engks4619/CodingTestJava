import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, board[][];
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0, 0, 1);
		System.out.println(count);
		in.close();
	}

	static void dfs(int direction, int lr, int lc, int rr, int rc) {
		if (rr == N - 1 && rc == N - 1) {
			count++;
			return;
		}
		// 가로인 경우
		if (direction == 0) {
			if (rc + 1 < N && board[rr][rc + 1] == 0)
				dfs(0, rr, rc, rr, rc + 1);

			if (rc + 1 < N && rr + 1 < N && board[rr][rc + 1] == 0 && board[rr + 1][rc] == 0
					&& board[rr + 1][rc + 1] == 0)
				dfs(1, rr, rc, rr + 1, rc + 1);
			// 세로인 경우
		} else if (direction == 2) {
			if (rr + 1 < N && board[rr + 1][rc] == 0)
				dfs(2, rr, rc, rr + 1, rc);
			if (rr + 1 < N && rc + 1 < N && board[rr + 1][rc] == 0 && board[rr][rc + 1] == 0
					&& board[rr + 1][rc + 1] == 0)
				dfs(1, rr, rc, rr + 1, rc + 1);
		} else { // 대각인 경우
			if (rc + 1 < N && board[rr][rc + 1] == 0)
				dfs(0, rr, rc, rr, rc + 1);
			if (rr + 1 < N && board[rr + 1][rc] == 0)
				dfs(2, rr, rc, rr + 1, rc);
			if (rr + 1 < N && rc + 1 < N && board[rr + 1][rc] == 0 && board[rr][rc + 1] == 0
					&& board[rr + 1][rc + 1] == 0)
				dfs(1, rr, rc, rr + 1, rc + 1);
		}

	}

}
