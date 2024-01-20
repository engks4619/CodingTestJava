import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, board[][];
	static boolean visited[][];
	static int[] result = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0, 0, N);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	static void go(int r, int c, int size) {
		int val = board[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (board[i][j] != val) {
					int nSize = size / 3;
					for(int nr = 0; nr < 3; nr++) {
						for(int nc = 0; nc < 3; nc++) {
							go(r + nr * nSize, c + nc * nSize, nSize);							
						}
					}
					return;
				}
			}
		}
		switch (val) {
		case -1:
			result[0]++;
			break;
		case 0:
			result[1]++;
			break;
		case 1:
			result[2]++;
			break;
		}

	}
}
