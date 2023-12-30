import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        visited = new boolean[N + 1];
        combination( 0);
        System.out.print(sb);
        in.close();
    }

    static void combination(int cnt){
        if(cnt == M){
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = i;
            combination(cnt + 1);
            visited[i] = false;
        }
    }
}