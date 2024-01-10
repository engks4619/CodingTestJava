import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N = 9;
    static int[][] board = new int[N][N];
    static List<Point> emptyList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0){
                    emptyList.add(new Point(i, j));
                }
            }
        }
        go(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(int cnt) {
       if(cnt == emptyList.size()) return true;
       Point next = emptyList.get(cnt);
       int r = next.r;
       int c = next.c;
       for (int num = 1; num <= 9; num++) {
           if(!isValidNumber(r, c, num)) continue;
           board[r][c] = num;
           if(go(cnt + 1)) return true;
           board[r][c] = 0;
       }
       return false;
    }

    static boolean isValidNumber(int r, int c, int num){
        for (int i = 0; i < N; i++) {
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

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}