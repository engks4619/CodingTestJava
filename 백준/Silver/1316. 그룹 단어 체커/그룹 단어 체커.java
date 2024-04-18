import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String word = in.readLine();
            if(isGroupWord(word)) cnt++;
        }
        System.out.println(cnt);
        in.close();
    }

    static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char c = word.charAt(0);
        visited[c - 'a'] = true;
        for (int i = 1; i < word.length(); i++) {
            char nC = word.charAt(i);
            if(nC != c) {
                if(visited[nC - 'a']) return false;
                c = nC;
                visited[nC - 'a'] = true;
            }
        }

        return true;
    }
}