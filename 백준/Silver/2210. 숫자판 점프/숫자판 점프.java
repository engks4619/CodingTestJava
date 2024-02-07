import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N = 5;
    static int[][] board = new int[N][N];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static HashSet<String> numberList = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                go(1, i, j, board[i][j] + "");
            }
        }
        bw.write(numberList.size() + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int depth, int r, int c, String str) {
        if(depth == 6) {
            numberList.add(str);
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            go(depth + 1, nr, nc, str + board[nr][nc]);
        }
    }
    
}