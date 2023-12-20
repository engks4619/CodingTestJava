import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i = M; i <= N; i++) {
            if(isPrime(i)) sb.append(i).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static boolean isPrime(int num){
        if(num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

}