import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int C, P, board[], cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        board = new int[C];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < C; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        switch (P) {
            case 1:
                go("0");
                go("0000");
                break;
            case 2:
                go("00");
                break;
            case 3:
                go("001");
                go("10");
                break;
            case 4:
                go("100");
                go("01");
                break;
            case 5:
                go("000");
                go("01");
                go("10");
                go("101");
                break;
            case 6:
                go("000");
                go("00");
                go("011");
                go("20");
                break;
            case 7:
                go("000");
                go("02");
                go("110");
                go("00");
                break;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(String str) {
        int n = str.length();
        for (int c = 0; c <= C - n; c++) {
            int diff = (str.charAt(0) - '0') - board[c];
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                if((str.charAt(i) - '0') - board[c + i] != diff) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) cnt++;
        }
    }

}