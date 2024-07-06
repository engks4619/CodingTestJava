import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = 0;
        while(true) {
            st = new StringTokenizer(in.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(P == 0 || L == 0 || V == 0) break;
            int answer = P * (V / L) + Math.min(P, V % L);
            sb.append("Case ").append(++tc).append(": ").append(answer).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}