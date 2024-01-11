import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, minCnt = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Point red = null, blue = null;
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'B') {
                    blue = new Point(i, j, 0);
                    board[i][j] = '.';
                }
                if(board[i][j] == 'R') {
                    red = new Point(i, j, 0);
                    board[i][j] = '.';
                }
            }
        }
        if(!go(red, blue)) minCnt = -1;
        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(Point sRed, Point sBlue) {
        Queue<Point[]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        queue.offer(new Point[] {sRed, sBlue});
        visited[sRed.r][sRed.c][sBlue.r][sBlue.c] = true;
        while(!queue.isEmpty()){
            Point[] curr = queue.poll();
            Point red = curr[0];
            Point blue = curr[1];
            if(isFallen(red) && !isFallen(blue)){
                minCnt = Math.min(minCnt, red.cnt);
                return true;
            }
            if(red.cnt > 10 || blue.cnt > 10) return false;
            for (int d = 0; d < dr.length; d++) {
                Point[] next = getNextPointArr(red, blue, d);
                if(next == null) continue;
                Point nRed = next[0];
                Point nBlue = next[1];
                if(visited[nRed.r][nRed.c][nBlue.r][nBlue.c]) continue;
                visited[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;
                queue.offer(new Point[] {nRed, nBlue});
            }
        }
        return false;
    }

    static boolean isFallen(Point point) {
        return board[point.r][point.c] == 'O';
    }

    static Point[] getNextPointArr(Point red, Point blue, int d) {
        Point nBlue = getNextPoint(blue, d);
        // 파란공은 구멍에 빠지면 안됨
        if(board[nBlue.r][nBlue.c] == 'O') return null;
        Point nRed = getNextPoint(red, d);
        // 겹침 유무 확인
        Point[] next = getValidBallArr(red, nRed, blue, nBlue, d);
        nRed = next[0];
        nBlue = next[1];
        return new Point[] {nRed, nBlue};
    }

    static Point getNextPoint(Point point, int d){
        int nr = point.r;
        int nc = point.c;
        while(true) {
            nr += dr[d];
            nc += dc[d];
            if(board[nr][nc] == 'O') break;
            if(board[nr][nc] == '#') {
                nr -= dr[d];
                nc -= dc[d];
                break;
            }
        }
        return new Point(nr, nc, point.cnt + 1);
    }

    static Point[] getValidBallArr(Point red, Point nRed, Point blue, Point nBlue, int d){
        if(nRed.r != nBlue.r || nRed.c != nBlue.c) return new Point[] {nRed, nBlue};
        switch (d) {
            case 0: // 상
                if(red.r > blue.r) nRed.setR(nRed.r + 1);
                else nBlue.setR(nBlue.r + 1);
                break;
            case 1: // 하
                if(red.r > blue.r) nBlue.setR(nBlue.r - 1);
                else nRed.setR(nRed.r - 1);
                break;
            case 2: // 좌
                if(red.c > blue.c) nRed.setC(nRed.c + 1);
                else nBlue.setC(nBlue.c + 1);
                break;
            case 3: // 우
                if(red.c > blue.c) nBlue.setC(nBlue.c - 1);
                else nRed.setC(nRed.c - 1);
                break;
        }
        return new Point[] {nRed, nBlue};
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

        public void setR(int r) {
            this.r = r;
        }

        public void setC(int c) {
            this.c = c;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}