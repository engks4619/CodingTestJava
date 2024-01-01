import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        selected = new int[N];
        visited = new boolean[N];
        permutation(0);
        System.out.print(sb);
        in.close();
    }

    static void permutation(int cnt){
        if(cnt == N){
            Arrays.stream(selected).forEach((num) -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = i + 1;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}