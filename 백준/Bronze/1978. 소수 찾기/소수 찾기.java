import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(isPrime(Integer.parseInt(st.nextToken()))) cnt++;
        }
        System.out.println(cnt);
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