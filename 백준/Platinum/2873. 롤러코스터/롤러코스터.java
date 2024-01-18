import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int R, C, mr, mc;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static String LEFT, RIGHT, UP, DOWN;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initString();
        //행 열 둘다 짝수인 경우
        if(R % 2 == 0 && C % 2 == 0) go();
        else {
            if(R % 2 != 0) goFull('Z');
            else goFull('N');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go() {
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = i % 2 == 0 ? 1 : 0; j < C; j += 2){
                if(board[i][j] < minVal) {
                    minVal = board[i][j];
                    mr = i;
                    mc = j;
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int sr = 0, sc = 0;
        int er = R - 1, ec = C - 1;

        while(er - sr > 1) {
            if(sr / 2 < mr / 2) {
                sb1.append(RIGHT).append('D').append(LEFT).append('D');
                sr += 2;
            }
            if(er / 2 > mr / 2) {
                sb2.append(RIGHT).append('D').append(LEFT).append('D');
                er -= 2;
            }
        }

        while(ec - sc > 1) {
            if(sc / 2 < mc / 2) {
                sb1.append("DRUR");
                sc += 2;
            }
            if(ec / 2 > mc / 2) {
                sb2.append("DRUR");
                ec -= 2;
            }
        }

        if(mc == sc) sb1.append("RD");
        else sb1.append("DR");
        sb.append(sb1).append(sb2.reverse());
    }

    static void initString() {
        StringBuilder l = new StringBuilder();
        StringBuilder r = new StringBuilder();
        StringBuilder u = new StringBuilder();
        StringBuilder d = new StringBuilder();
        for (int i = 0; i < C - 1; i++) {
            l.append('L');
            r.append('R');
        }
        for (int i = 0; i < R - 1; i++) {
            u.append('U');
            d.append('D');
        }
        LEFT = l.toString();
        RIGHT = r.toString();
        UP = u.toString();
        DOWN = d.toString();
    }

    static void goFull(char d) {
        int size = d == 'Z' ? R : C;
        for (int i = 0; i < size; i++) {
            if(i % 2 == 0) sb.append(d == 'Z' ? RIGHT : DOWN);
            else sb.append(d == 'Z' ? LEFT : UP);
            if(i != size - 1) sb.append(d == 'Z' ? 'D' : 'R');
        }
    }

}