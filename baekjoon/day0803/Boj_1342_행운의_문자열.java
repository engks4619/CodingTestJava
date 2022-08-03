package baekjoon.day0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1342_행운의_문자열 {

    static int result, N;
    static int[] counter = new int[27];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        N = S.length();
        for (char c : S.toCharArray())
            counter[c-'a']++;
        dfs(0, -1);
        System.out.println(result);
        in.close();
    }

    public static void dfs(int cnt, int prev) {
        if (cnt == N) {
            result++;
            return;
        }
        for(int i = 0; i < 27; i++){
            if(prev == i || counter[i] <= 0)
                continue;
            counter[i]--;
            dfs(cnt + 1, i);
            counter[i]++;
        }
    }
}
