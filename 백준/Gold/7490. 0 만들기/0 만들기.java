import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        while(TC-- > 0) {
            N = Integer.parseInt(in.readLine());
            go(1, "1");
            sb.append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void go(int cnt, String express) {
        if(cnt == N) {
            if(calc(express) == 0)
                sb.append(express).append("\n");
            return;
        }
        go(cnt + 1, express + " " + (cnt + 1));
        go(cnt + 1, express + "+" + (cnt + 1));
        go(cnt + 1, express + "-" + (cnt + 1));
    }

    static int calc(String express) {
        express = express.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(express, "[+,-]", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(str.equals("+")) sum += Integer.parseInt(st.nextToken());
            else sum -= Integer.parseInt(st.nextToken());
        }
        return sum;
    }

}