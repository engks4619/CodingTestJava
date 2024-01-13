import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, minCnt = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sr = -1, sc = -1, er = -1, ec = - 1;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == '#'){
                    if(sr == -1) {
                        sr = i;
                        sc = j;
                    }else {
                        er = i;
                        ec = j;
                    }
                    board[i][j] = '.';
                }
            }
        }
        bfs();
        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][N][4];
        queue.offer(new int[] {sr, sc, 0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            if(r == er && c == ec){
                minCnt = cnt - 1;
                return;
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = r;
                int nc = c;
                while(true) {
                    nr += dr[d];
                    nc += dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N
                            || visited[nr][nc][d] || board[nr][nc] == '*') break;
                    visited[nr][nc][d] = true;
                    if(board[nr][nc] == '!' || (nr == er && nc == ec)) {
                        queue.offer(new int[] {nr, nc, cnt + 1});
                    }
                }
            }
        }

    }

}