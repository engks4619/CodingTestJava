import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, K, maxCnt;
    static boolean[] alpha = new boolean[26];
    static String[] wordArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wordArr = new String[N];
        for (int i = 0; i < N; i++) {
            wordArr[i] = in.readLine();
        }
        if(K >= 5){
            // a c t i n 5개 기본
            alpha['a' - 'a'] = true;
            alpha['c' - 'a'] = true;
            alpha['t' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['n' - 'a'] = true;
            K -= 5;
            go(0, 0);
        }
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int curr, int cnt){
        if(cnt == K){
            maxCnt = Math.max(maxCnt, getWordCnt());
            return;
        }
        for (int i = curr; i < 26; i++) {
            if(alpha[i]) continue;
            alpha[i] = true;
            go(i, cnt + 1);
            alpha[i] = false;
        }
    }

    static int getWordCnt(){
        int cnt = 0;
        for(String word : wordArr){
            for (int i = 0; i < word.length(); i++) {
                if(!alpha[word.charAt(i) - 'a']) break;
                if(i == word.length() - 1) cnt++;
            }
        }
        return cnt;
    }

}