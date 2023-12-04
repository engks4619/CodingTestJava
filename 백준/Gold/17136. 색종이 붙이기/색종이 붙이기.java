import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int BOARD_SIZE = 10;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    static int PAPER_SIZE = 5;
    static int PAPER_CNT = 5;
    static int ONE_CNT = 0;
    static int[] paperArr = new int[PAPER_SIZE + 1];
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= PAPER_SIZE; i++) {
            paperArr[i] = PAPER_CNT;
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < BOARD_SIZE; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < BOARD_SIZE; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) ONE_CNT++;
            }
        }
        go(0, 0, 0, ONE_CNT);
        System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);
        in.close();
    }


    static void go(int r, int c, int cnt, int oneCnt){
        // 이미 최소갯수를 넘는 경우
        if(cnt >= minCnt) return;
        // 다 채운 경우
        if(oneCnt == 0){
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        if(c >= BOARD_SIZE){
            go(r + 1, 0, cnt, oneCnt);
            return;
        }
        if(board[r][c] == 1){
            for(int size = PAPER_SIZE; size > 0; size--){
                if(!checkBoard(r, c, size) || paperArr[size] <= 0) continue;
                // 색종이 붙이기
                stickPaper(r, c, size, true);
                paperArr[size]--;
                go(r, c + 1, cnt + 1, oneCnt - size * size);
                // 색종이 떼기
                stickPaper(r, c, size, false);
                paperArr[size]++;
            }
        }else{
            go(r, c + 1, cnt, oneCnt);
        }
    }

    static boolean checkBoard(int r, int c, int size){
        if(r < 0 || r + size > BOARD_SIZE || c < 0 || c + size > BOARD_SIZE) return false;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(board[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void stickPaper(int r, int c, int size , boolean flag){
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = flag ? 0 : 1;
            }
        }
    }

}