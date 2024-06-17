import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getCnt(Integer.parseInt(in.readLine())));
        in.close();
    }

    static int getCnt(int num) {
        if(num < 100) return num;
        int cnt = 99;
        for (int i = 100; i <= num; i++) {
            if(isHan(i)) cnt++;
        }
        return cnt;
    }

    static boolean isHan(int num) {
        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;
        return a - b == b - c;
    }

}