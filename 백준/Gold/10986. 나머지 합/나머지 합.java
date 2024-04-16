import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] cnt = new long[M];
        long sum = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= M;
            cnt[(int) sum]++;
        }
        long answer = cnt[0];
        for (int i = 0; i < M; i++) {
            answer += (cnt[i] * (cnt[i] - 1)) / 2;
        }
        System.out.println(answer);
        in.close();
    }
}