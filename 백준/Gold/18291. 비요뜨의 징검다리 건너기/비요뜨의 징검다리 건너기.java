import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static long MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            if (N == 1 || N == 2) {
                sb.append(1).append("\n");
            } else {
                sb.append(pow(N - 2)).append("\n");
            }
        }
        System.out.println(sb);
        in.close();
    }

    public static long pow(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 2;
        long n = pow(num / 2);
        return (n * n * (num % 2 + 1)) % MOD;
    }
}