import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long result = (int)Math.pow(10, 9);
    static long A, B;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        func(A, 0);
        System.out.println(result == (int)Math.pow(10, 9) ? -1 : result + 1);
    }

    public static void func(long num, long cnt) {
        if(cnt >= result) {
            return;
        }
        if(num > Math.pow(10, 9)) {
            return;
        }
        if(num == B) {
            result = Math.min(result, cnt);
            return;
        }
        func(num * 2, cnt+1);
        func(num * 10 + 1, cnt+1);
    }
}