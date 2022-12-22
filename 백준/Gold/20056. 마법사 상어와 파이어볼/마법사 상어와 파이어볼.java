import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static Queue<Item>[][] board;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Item {
        int m, s, d;

        public Item(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayDeque<Item>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[r][c].offer(new Item(m, s, d));
        }
        while(K-- > 0){
            moveFireBall();
            cleanFireBall();
        }
        System.out.println(sumFireBallM());
        in.close();
    }

    public static void moveFireBall() {
        Queue<Item>[][] newBoard = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = new ArrayDeque<Item>();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!board[i][j].isEmpty()) {
                    Item curr = board[i][j].poll();
                    int nr = (i + dr[curr.d] * curr.s) % N;
                    int nc = (j + dc[curr.d] * curr.s) % N;
                    if (nr < 0) nr = nr + N;
                    if (nc < 0) nc = nc + N;
                    newBoard[nr][nc].offer(new Item(curr.m, curr.s, curr.d));
                }
            }
        }
        board = newBoard;
    }

    public static void cleanFireBall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int totalCnt = board[i][j].size();
                if (totalCnt <= 1) continue;
                int oCnt = 0, eCnt = 0, mSum = 0, sSum = 0;
                while (!board[i][j].isEmpty()) {
                    Item curr = board[i][j].poll();
                    if (curr.d % 2 == 1)
                        oCnt++;
                    else
                        eCnt++;
                    mSum += curr.m;
                    sSum += curr.s;
                }
                int nM = mSum / 5;
                int nS = sSum / totalCnt;
                if(nM == 0) continue;
                if(oCnt == 0 || eCnt == 0){
                    board[i][j].offer(new Item(nM, nS, 0));
                    board[i][j].offer(new Item(nM, nS, 2));
                    board[i][j].offer(new Item(nM, nS, 4));
                    board[i][j].offer(new Item(nM, nS, 6));
                }else{
                    board[i][j].offer(new Item(nM, nS, 1));
                    board[i][j].offer(new Item(nM, nS, 3));
                    board[i][j].offer(new Item(nM, nS, 5));
                    board[i][j].offer(new Item(nM, nS, 7));
                }
            }
        }
    }

    public static int sumFireBallM() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Item item : board[i][j]) {
                    sum += item.m;
                }
            }
        }
        return sum;
    }
}