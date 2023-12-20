import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int cnt = 0;
        while(N > 0){
            cnt += N / 5;
            N /= 5;
        }
        System.out.println(cnt);
        in.close();
    }
}