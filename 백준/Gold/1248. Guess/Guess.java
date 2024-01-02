import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int N;
    static int[] selected;
    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        selected = new int[N];
        String str = in.readLine();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            queue.offer(str.charAt(i));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                board[i][j + i] = queue.poll();
            }
        }
        go(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(int cnt){
        if(!checkLogic(cnt)) return false;
        if(cnt == N) {
            Arrays.stream(selected).forEach((num) -> sb.append(num).append(" "));
            return true;
        }
        for (int i = 0; i <= 20; i++) {
            selected[cnt] = i - 10;
            if(go(cnt + 1)) return true;
        }
        return false;
    }

    static boolean checkLogic(int boardSize){
        for (int i = 0; i < boardSize; i++) {
            int sum = 0;
            for (int j = i; j < boardSize; j++) {
                sum += selected[j];
                if(board[i][j] != getSign(sum)) return false;
            }
        }
        return true;
    }

    static char getSign(int num){
        if(num < 0) return '-';
        else if(num > 0) return '+';
        else return '0';
    }
}