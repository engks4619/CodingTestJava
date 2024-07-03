import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(in.readLine());
            if(N == 0) break;
            sb.append(isPalindrome(N) ? "yes" : "no").append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static boolean isPalindrome(int num) {
        String str = num + "";
        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

}