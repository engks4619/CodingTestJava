import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] cntArr = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        go(1, N, 1);
        for(int cnt : cntArr){
            System.out.print(cnt + " ");
        }
        in.close();
    }

    static void go(int A, int B, int digit) {
        while(A % 10 != 0 && A <= B) {
            calc(A, digit);
            A++;
        }
        if(A > B) return;
        while(B % 10 != 9 && A <= B) {
            calc(B, digit);
            B--;
        }
        int tmp = B / 10 - A / 10 + 1;
        for (int i = 0; i < 10; i++) {
            cntArr[i] += tmp * digit;
        }
        go(A / 10, B / 10, digit * 10);
    }

    static void calc(int num, int digit) {
        while(num > 0) {
            cntArr[num % 10] += digit;
            num /= 10;
        }
    }

}