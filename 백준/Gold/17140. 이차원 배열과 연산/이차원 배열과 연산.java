import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] board = new int[100][100];
    static int maxR = 3, maxC = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while(board[r][c] != k && time <= 101) {
            if(maxR >= maxC) rFunc();
            else cFunc();
            time++;
        }
        System.out.println(time <= 100 ? time : -1);
        in.close();
    }

    static void rFunc() {
        int[][] tmpBoard = new int[100][100];
        for (int r = 0; r < maxR; r++) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0]
            );
            for (int c = 0; c < maxC; c++) {
                if(board[r][c] == 0) continue;
                cntMap.compute(board[r][c], (num, cnt) -> cnt == null ? 1 : cnt + 1);
            }
            cntMap.forEach((num, cnt) -> pq.add(new int[] {num, cnt}));
            int c = 0;
            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                tmpBoard[r][c++] = curr[0];
                tmpBoard[r][c++] = curr[1];
            }
            maxC = Math.max(maxC, c);
        }
        board = tmpBoard;
    }

    static void cFunc() {
        int[][] tmpBoard = new int[100][100];
        for (int c = 0; c < maxC; c++) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0]
            );
            for (int r = 0; r < maxR; r++) {
                if(board[r][c] == 0) continue;
                cntMap.compute(board[r][c], (num, cnt) -> cnt == null ? 1 : cnt + 1);
            }
            cntMap.forEach((num, cnt) -> pq.add(new int[] {num, cnt}));
            int r = 0;
            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                tmpBoard[r++][c] = curr[0];
                tmpBoard[r++][c] = curr[1];
            }
            maxR = Math.max(maxR, r);
        }
        board = tmpBoard;
    }

}