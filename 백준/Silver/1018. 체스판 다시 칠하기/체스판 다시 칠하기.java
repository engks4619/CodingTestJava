import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] board;
    static int SIZE = 8;
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) == 'W' ? false : true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                go(i, j);
            }
        }
        System.out.println(minCnt);
        in.close();
    }

    static void go(int r, int c){
        if(r < 0 || r + SIZE > N || c < 0 || c + SIZE > M) return;
        int cnt = Math.min(getChangeCnt(r, c, false), getChangeCnt(r, c, true));
        minCnt = Math.min(minCnt, cnt);
        return;
    }

    static int getChangeCnt(int r, int c, boolean flag){
        int cnt = 0;
        for(int i = r; i < r + SIZE; i++){
            for(int j = c; j < c + SIZE; j++){
                if(board[i][j] != flag) cnt++;
                flag = !flag;
            }
            flag = !flag;
        }
        return cnt;
    }
    
}