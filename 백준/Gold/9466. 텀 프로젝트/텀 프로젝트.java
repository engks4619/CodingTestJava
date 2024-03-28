import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, cnt, arr[];
    static boolean[] visited, finished;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(TC-- > 0) {
            N = Integer.parseInt(in.readLine());
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;
            arr = new int[N + 1];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <= N; i++) {
                if(!finished[i]) dfs(i);
            }
            sb.append(N - cnt).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void dfs(int idx) {
        int next = arr[idx];
        if(visited[idx]) {
            finished[idx] = true;
            cnt++;
        }
        else visited[idx] = true;

        if(!finished[next]) dfs(next);

        visited[idx] = false;
        finished[idx] = true;
    }

}