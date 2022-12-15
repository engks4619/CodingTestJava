import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num, board[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(in.readLine());
        int N = (int) Math.pow(2, K);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        board[y][x] = -1;
        function(1, 1, N);
        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        in.close();
    }

    public static boolean validate(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void function(int r, int c, int size) {
        int newSize = size / 2;
        num++;
        if (validate(r, c, newSize)) board[r + newSize - 1][c + newSize - 1] = num;
        if (validate(r, c + newSize, newSize)) board[r + newSize - 1][c + newSize] = num;
        if (validate(r + newSize, c, newSize)) board[r + newSize][c + newSize - 1] = num;
        if (validate(r + newSize, c + newSize, newSize)) board[r + newSize][c + newSize] = num;

        if (size == 2) return;

        function(r, c, newSize);
        function(r + newSize, c, newSize);
        function(r, c + newSize, newSize);
        function(r + newSize, c + newSize, newSize);
    }
}