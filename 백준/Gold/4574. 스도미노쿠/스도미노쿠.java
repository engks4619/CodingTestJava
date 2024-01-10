import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int BOARD_SIZE = 9;
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] isUsedDomino;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = 1;
        while(true){
            N = Integer.parseInt(in.readLine());
            if(N == 0) break;
            board = new int[BOARD_SIZE][BOARD_SIZE];
            isUsedDomino = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(i == j) isUsedDomino[i][j] = true;
                }
            }
            sb.append("Puzzle ").append(TC++).append("\n");
            // 보드 입력값 초기화
            for (int i = 0; i < N; i++) {
                initTwoSizeDomino(new StringTokenizer(in.readLine()));
            }
            initOneSizeDomino(new StringTokenizer(in.readLine()));
            go(0, 0);

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(int r, int c){
        if(r == 9){
            printBoard();
            return true;
        }
        if(c == 9){
            if(go(r + 1, 0)) return true;
            else return false;
        }
        if(board[r][c] != 0){
            if(go(r, c + 1)) return true;
            else return false;
        }
        Domino dominoA;
        Domino dominoB;
        for (int numA = 1; numA <= 9; numA++) {
            if(!isValidNumber(new Domino(r, c, numA))) continue;
            dominoA = new Domino(r, c, numA);
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!isValidRange(nr, nc) || board[nr][nc] != 0) continue;
                for (int num2 = 1; num2 <= 9; num2++) {
                    if(!isValidNumber(new Domino(nr, nc, num2))) continue;
                    dominoB = new Domino(nr, nc, num2);
                    if(isValidDomino(dominoA, dominoB)){
                        board[dominoA.r][dominoA.c] = dominoA.num;
                        board[dominoB.r][dominoB.c] = dominoB.num;
                        isUsedDomino[dominoA.num][dominoB.num] = true;
                        isUsedDomino[dominoB.num][dominoA.num] = true;
                        if(go(r, c + 1)) return true;
                        isUsedDomino[dominoA.num][dominoB.num] = false;
                        isUsedDomino[dominoB.num][dominoA.num] = false;
                        board[dominoB.r][dominoB.c] = 0;
                        board[dominoA.r][dominoA.c] = 0;
                    }
                }
            }
        }

        return false;
    }

    static void printBoard(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
    }

    static void initTwoSizeDomino(StringTokenizer st){
        int numA = Integer.parseInt(st.nextToken());
        String posA = st.nextToken();
        int rA = posA.charAt(0) - 'A';
        int cA = posA.charAt(1) - '0' - 1;
        board[rA][cA] = numA;
        int numB = Integer.parseInt(st.nextToken());
        String posB = st.nextToken();
        int rB = posB.charAt(0) - 'A';
        int cB = posB.charAt(1) - '0' - 1;
        board[rB][cB] = numB;
        isUsedDomino[numA][numB] = true;
        isUsedDomino[numB][numA] = true;
    }

    static void initOneSizeDomino(StringTokenizer st){
        for (int num = 1; num <= 9; num++) {
            String pos = st.nextToken();
            int r = pos.charAt(0) - 'A';
            int c = pos.charAt(1) - '0' - 1;
            board[r][c] = num;
        }
    }

    static boolean isValidDomino(Domino dominoA, Domino dominoB){
        // 범위 확인
        if(!isValidRange(dominoA.r, dominoA.c) || !isValidRange(dominoB.r, dominoB.c)
        // 사용 유무 확인
        || isUsedDomino[dominoA.num][dominoB.num] || isUsedDomino[dominoB.num][dominoA.num]
        // 스도쿠 룰 위배 확인
        || !isValidNumber(dominoA) || !isValidNumber(dominoB)) return false;
        return true;
    }

    static boolean isValidRange(int r, int c){
        return r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE;
    }

    static boolean isValidNumber(Domino domino){
        int r = domino.r;
        int c = domino.c;
        int num = domino.num;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board[r][i] == num) return false;
            if(board[i][c] == num) return false;
        }
        int sR = r / 3 * 3;
        int sC = c / 3 * 3;
        for (int i = sR; i < sR + 3; i++) {
            for (int j = sC; j < sC + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

    static class Domino {
        int r;
        int c;
        int num;

        public Domino(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}