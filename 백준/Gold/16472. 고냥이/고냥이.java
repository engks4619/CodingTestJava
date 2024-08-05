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
            // 이미 사용된 알파벳인 경우
            if(cntArr[c - 'a'] > 0) {
                cntArr[c - 'a']++;
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
                continue;
            }
            // 사용되지 않았던 알파벳인 경우
            if(cnt < N) { // 사용할 수 있는 횟수가 남은 경우
                cntArr[c - 'a']++;
                cnt++;
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            } else { // 사용할 수 있는 횟수가 없는 경우
                do cntArr[str.charAt(l) - 'a']--;
                while(cntArr[str.charAt(l++) - 'a'] > 0);
                cnt--;
            }
        }
        System.out.println(maxLength);
        in.close();
    }
}