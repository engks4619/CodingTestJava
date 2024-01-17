import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(K == 0) {
            for (int i = 0; i < N; i++) {
                sb.append('A');
            }
        }else {
            for (int a = 0; a <= N; a++) {
                int b = N - a;
                if(a * b < K) continue;
                for (int i = 0; i < a - 1; i++) {
                    sb.append('A');
                }
                for (int i = 0; i < b; i++) {
                    sb.append('B');
                }
                int idx = N - 1 - (K - (a - 1) * b);
                sb.setCharAt(idx, 'A');
                sb.append('B');
                break;
            }
        }
        System.out.println(sb.toString().equals("") ? "-1" : sb.toString());
        in.close();
    }

}