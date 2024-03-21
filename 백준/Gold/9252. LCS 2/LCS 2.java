import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String strA = in.readLine();
        String strB = in.readLine();
        int[][] dp = new int[strA.length() + 1][strB.length() + 1];
        for (int i = 1; i <= strA.length(); i++) {
            for (int j = 1; j <= strB.length(); j++) {
                if(strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[strA.length()][strB.length()]).append("\n");

        Stack<Character> stack = new Stack<>();
        int i = strA.length();
        int j = strB.length();
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i - 1][j]) i--;
            else if(dp[i][j] == dp[i][j - 1]) j--;
            else {
                stack.push(strA.charAt(i - 1));
                i--;
                j--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
        in.close();
    }

}