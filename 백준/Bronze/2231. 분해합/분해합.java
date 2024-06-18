import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if(go(i, N)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
        in.close();
    }

    static boolean go(int num, int N) {
        int sum = num;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum == N;
    }

}