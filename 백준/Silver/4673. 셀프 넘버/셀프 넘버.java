import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isNotSelfNumber = new boolean[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10000; i++) {
            go(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if(!isNotSelfNumber[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void go(int num) {
        int sum = num;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if(num + sum <= 10000) isNotSelfNumber[num + sum] = true;
    }

}