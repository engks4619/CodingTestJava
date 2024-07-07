import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] cntArr = new int['Z' - 'A' + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(char c : in.readLine().toCharArray()) {
            cntArr[c - 'A']++;
        }
        System.out.println(getPalindrome());
        in.close();
    }

    static String getPalindrome() {
        int oddCnt = 0;
        char odd = ' ';
        for (int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] % 2 != 0) {
                odd = (char)(i + 'A');
                oddCnt++;
            }
        }

        if(oddCnt > 1) {
            return "I'm Sorry Hansoo";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cntArr.length; i++) {
            for (int j = 0; j < cntArr[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        StringBuilder answer = new StringBuilder(sb.toString());
        if(oddCnt == 1) answer.append(odd);
        answer.append(sb.reverse());
        return answer.toString();
    }

}