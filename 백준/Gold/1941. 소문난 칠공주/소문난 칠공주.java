import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N = 5, answer;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[] visited = new boolean[1 << N * N];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 'S') go(1, 0, 1 << (i * N + j));
                else go(0, 1, 1 << (i * N + j));
            }
        }
        System.out.println(answer);
        in.close();
    }

    static void go(int sCnt, int yCnt, int log) {
        if(yCnt >= 4) return;
        if(sCnt + yCnt == 7) {
            if(sCnt >= 4) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < N * N; i++) {
            if((log & 1 << i) == 0) continue;
            int r = i / N;
            int c = i % N;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nextLog = log | 1 << (nr * N + nc);
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nextLog]) continue;
                visited[nextLog] = true;
                if(board[nr][nc] == 'S') go(sCnt + 1, yCnt, nextLog);
                else go(sCnt, yCnt + 1, nextLog);
            }
        }
    }

}