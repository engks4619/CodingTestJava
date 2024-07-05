import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int cnt = 1;
        int sum = 1;
        while(N > sum) {
            sum += 6 * cnt++;
        }
        System.out.println(cnt);
        in.close();
    }
}