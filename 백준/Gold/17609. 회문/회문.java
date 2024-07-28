import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            arr = in.readLine().toCharArray();
            sb.append(getIsPalindrome(0, arr.length - 1, 0))
                    .append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int getIsPalindrome(int l, int r, int diffCnt) {
        while(l < r) {
            if(arr[l] == arr[r]) {
                l++;
                r--;
                continue;
            }
            diffCnt++;
            if(diffCnt > 1) return 2;
            if(getIsPalindrome(l + 1, r, diffCnt) == 1
                    || getIsPalindrome(l, r - 1, diffCnt) == 1)
                return 1;
        }
        return diffCnt == 0 ? 0 : 1;
    }

}