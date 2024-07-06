import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int cnt = 0;
        while(true) {
            if(N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            N -= 2;
            cnt++;
            if(N < 0) {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
        in.close();
    }
}