import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = in.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) == '.' ? 'D' : str.charAt(j);
            }
        }
        boolean isPossible = true;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 'S' && !checkPossible(i, j)) {
                    isPossible = false;
                    break;
                }
            }
        }
        if(isPossible){
            sb.append("1\n");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        else sb.append("0\n");
        System.out.print(sb);
        in.close();
    }

    static boolean checkPossible(int r, int c) {
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(board[nr][nc] == 'W') return false;
        }
        return true;
    }
}