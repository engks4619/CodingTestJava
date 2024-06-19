import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        go(0, 0);
        System.out.print(sb);
        in.close();
    }

    static void go(int cnt, int num) {
        if(cnt == N){
            if(isPrime(num)) sb.append(num).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            int next = num * 10 + i;
            if(isPrime(next)) go(cnt + 1, next);
        }
    }

    static boolean isPrime(int num) {
        if(num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

}