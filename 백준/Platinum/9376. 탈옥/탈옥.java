import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Point> prisonerList;
    static final int MAX_COUNT = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0) {
            init(in);
            int minDoorCnt = getMinDoorCnt(
                    getDoorBoard(new Point(0, 0)),
                    getDoorBoard(prisonerList.get(0)),
                    getDoorBoard(prisonerList.get(1))
            );
            sb.append(minDoorCnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static int getMinDoorCnt(int[][] boardA, int[][] boardB, int[][] boardC) {
        int minCnt = MAX_COUNT;
        for (int i = 0; i <= H + 1; i++) {
            for (int j = 0; j <= W + 1; j++) {
                int tmp = boardA[i][j] + boardB[i][j] + boardC[i][j];
                tmp = board[i][j] == '#' ? tmp - 2 : tmp;
                minCnt = Math.min(minCnt, tmp);
            }
        }
        return minCnt;
    }

    static int[][] getDoorBoard(Point point) {
        int[][] doorBoard = new int[H + 2][W + 2];
        for (int i = 0; i <= H + 1; i++) {
            Arrays.fill(doorBoard[i], MAX_COUNT);
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(point);
        doorBoard[point.r][point.c] = 0;
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if(nr < 0 || nr >= H + 2 || nc < 0 || nc >= W + 2 || board[nr][nc] == '*') continue;
                if(board[nr][nc] == '.' && doorBoard[nr][nc] > doorBoard[curr.r][curr.c]) {
                    doorBoard[nr][nc] = doorBoard[curr.r][curr.c];
                    queue.offer(new Point(nr, nc));
                }
                else if(board[nr][nc] == '#' && doorBoard[nr][nc] > doorBoard[curr.r][curr.c] + 1) {
                    doorBoard[nr][nc] = doorBoard[curr.r][curr.c] + 1;
                    queue.offer(new Point(nr, nc));
                }
            }

        }
        return doorBoard;
    }

    static void init(BufferedReader in) throws Exception {
        StringTokenizer st = new StringTokenizer(in.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H + 2][W + 2];
        for (int i = 0; i <= H + 1; i++) {
            Arrays.fill(board[i], '.');
        }
        prisonerList = new ArrayList<>();
        for (int i = 1; i <= H; i++) {
            String input = in.readLine();
            for (int j = 1; j <= W; j++) {
                board[i][j] = input.charAt(j - 1);
                if(board[i][j] == '$') {
                    board[i][j] = '.';
                    prisonerList.add(new Point(i, j));
                }
            }
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}