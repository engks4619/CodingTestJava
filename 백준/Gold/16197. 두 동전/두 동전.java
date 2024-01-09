import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, minCnt = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N + 2][M + 2];
        Point coinA = null;
        Point coinB = null;
        for (int i = 1; i <= N; i++) {
            String str = in.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j - 1);
                if(board[i][j] == 'o'){
                    if(coinA == null) coinA = new Point(i, j, 0);
                    else coinB = new Point(i, j, 0);
                    board[i][j] = '.';
                }
            }
        }
        go(coinA, coinB);
        minCnt = minCnt == Integer.MAX_VALUE ? -1 : minCnt;
        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(Point coinA, Point coinB) {
        Queue<Point[]> queue = new ArrayDeque<>();
        queue.offer(new Point[] {coinA, coinB});
        while(!queue.isEmpty()){
            Point[] curr = queue.poll();
            coinA = curr[0];
            coinB = curr[1];
            if(coinA.cnt > 10) return;
            if(checkFallen(coinA) && checkFallen(coinB)) continue;
            if(checkFallen(coinA) ^ checkFallen(coinB)) {
                minCnt = Math.min(minCnt, coinA.cnt);
                return;
            }
            for (int d = 0; d < dr.length; d++) {
                Point nCoinA = getNextCoin(coinA, d);
                Point nCoinB = getNextCoin(coinB, d);
                if(nCoinA.equals(coinA) && nCoinB.equals(coinB)) continue;
                queue.offer(new Point[] {nCoinA, nCoinB});
            }
        }
    }

    static boolean checkFallen(Point coin) {
        return coin.r == 0 || coin.r == N + 1 || coin.c == 0 || coin.c == M + 1;
    }

    static Point getNextCoin(Point coin, int d) {
       Point nCoin = new Point(coin.r + dr[d], coin.c + dc[d], coin.cnt + 1);
       return isValidRange(nCoin) ? nCoin : new Point (coin.r, coin.c, coin.cnt + 1);
    }

    static boolean isValidRange(Point coin) {
       if(coin.r < 0 || coin.r >= N + 2 || coin.c < 0 || coin.c >= M + 2
               || board[coin.r][coin.c] == '#') return false;
       return true;
    }

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

}