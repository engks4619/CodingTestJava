import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> cheeseList = new ArrayList<>();
    static Queue<int[]> outAirQueue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) cheeseList.add(new int[] {i, j});
            }
        }
        initOutAir();
        int time = 0;
        while(cheeseList.size() > 0) {
            divideOutAir();
            meltCheese();
            time++;
        }
        System.out.println(time);
        in.close();
    }

    static void initOutAir() {
        outAirQueue.offer(new int[] {0, 0});
        board[0][0] = -1;
    }

    static void divideOutAir() {
        while(!outAirQueue.isEmpty()) {
            int[] curr = outAirQueue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != 0) continue;
                board[nr][nc] = -1;
                outAirQueue.offer(new int[] {nr, nc});
            }
        }
    }

    static void meltCheese() {
        Queue<int[]> meltPosQueue = new ArrayDeque<>();
        int size = cheeseList.size();
        for (int i = size - 1; i >= 0; i--) {
            int[] pos = cheeseList.get(i);
            int r = pos[0];
            int c = pos[1];
            if(checkIsMelt(r, c)) {
                meltPosQueue.offer(pos);
                cheeseList.remove(i);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1 && checkIsMelt(i, j)) meltPosQueue.offer(new int[] {i, j});
            }
        }
        while(!meltPosQueue.isEmpty()) {
            int[] pos = meltPosQueue.poll();
            board[pos[0]][pos[1]] = -1;
            outAirQueue.offer(pos);
        }
    }

    static boolean checkIsMelt(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(board[nr][nc] == -1) cnt++;
        }
        return cnt >= 2;
    }

}