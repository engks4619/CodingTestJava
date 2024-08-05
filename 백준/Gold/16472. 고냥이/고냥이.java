import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();
        int[] cntArr = new int[26];
        int l = 0;
        int r = 0;
        int cnt = 0;
        int maxLength = 0;
        while(r < str.length()) {
            char c = str.charAt(r);
            if(cnt < N) {
                if(cntArr[c - 'a'] == 0) cnt++;
                cntArr[c - 'a']++;
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            } else {
                if(cntArr[c - 'a'] != 0) {
                    cntArr[c - 'a']++;
                    maxLength = Math.max(maxLength, r - l + 1);
                    r++;
                } else {
                    int lc = str.charAt(l);
                    cntArr[lc - 'a']--;
                    if(cntArr[lc - 'a'] == 0) cnt--;
                    l++;
                }
            }
        }
        System.out.println(maxLength);
        in.close();
    }
}