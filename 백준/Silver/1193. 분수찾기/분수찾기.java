import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        int tmp = 0;
        int A = 0;
        int B = 0;
        for (int i = 1; i <= num; i++) {
            if(tmp < num && num <= tmp + i) {
                int diff = num - tmp;
                if(i % 2 != 0) {
                    A = i + 1 - diff;
                    B = diff;
                }
                else {
                    A = diff;
                    B = i + 1 - diff;
                }
                break;
            }
            tmp += i;
        }
        System.out.println(A + "/" + B);
        in.close();
    }
}