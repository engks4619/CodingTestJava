import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String answer;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        go(1, "1");
        System.out.println(answer);
        in.close();
    }

    static boolean go(int depth, String num) {
        if(!isGood(num)) return false;
        if(depth == N) {
            answer = num;
            return true;
        }
        for (int i = 1; i <= 3; i++) {
            if(go(depth + 1, num + i))
                return true;
        }
        return false;
    }

    static boolean isGood(String num) {
        int len = num.length();
        for (int i = 1; i <= len / 2; i++) {
            String left = num.substring(len - 2 * i,len - i);
            String right = num.substring(len - i, len);
            if(left.equals(right)) return false;
        }
        return true;
    }

}