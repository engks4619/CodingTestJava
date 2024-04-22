import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX = 101;
    static boolean[][] board = new boolean[MAX][MAX];
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawDragonCurve(r, c, getDirectionList(d, g));
        }
        System.out.println(getRectangleCnt());
        in.close();
    }

    static List<Integer> getDirectionList(int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);
        while(g-- > 0) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.add((list.get(i) + 1) % 4);
            }
        }
        return list;
    }

    static void drawDragonCurve(int r, int c, List<Integer> directionList) {
        board[r][c] = true;
        int nr = r;
        int nc = c;
        for (int d : directionList) {
            nr += dr[d];
            nc += dc[d];
            if(nr < 0 || nr >= MAX || nc < 0 || nc >= MAX) continue;
            board[nr][nc] = true;
        }
    }

    static int getRectangleCnt() {
        int cnt = 0;
        for (int i = 0; i < MAX - 1; i++) {
            for (int j = 0; j < MAX - 1; j++) {
                if(board[i][j] && board[i + 1][j]
                        && board[i][j + 1] && board[i + 1][j + 1]) cnt++;
            }
        }
        return cnt;
    }

}