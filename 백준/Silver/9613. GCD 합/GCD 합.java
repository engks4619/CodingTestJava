import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] numArr = new int[N];
            for (int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    sum += gcd(numArr[i], numArr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static long gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}