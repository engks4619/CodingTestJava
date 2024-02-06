import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static String A;
    static int B, maxValue = -1;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[A.length()];
        permutation(0, "");
        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void permutation(int depth, String str) {
        if(depth == A.length()) {
            int num = Integer.parseInt(str);
            if(num < Math.pow(10, A.length() - 1)) return;
            if(num < B) maxValue = Math.max(maxValue, Integer.parseInt(str));
            return;
        }
        for (int i = 0; i < A.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permutation(depth + 1, str + A.charAt(i));
            visited[i] = false;
        }

    }

}