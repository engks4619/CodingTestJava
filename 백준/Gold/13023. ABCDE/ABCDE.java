import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            if(go(i, 1)) {
                res = 1;
                break;
            }
        }
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean go(int curr, int cnt){
        if(cnt == 5){
            return true;
        }
        for(int next :list[curr]){
            if(visited[next]) continue;
            visited[next] = true;
            if(go(next, cnt + 1)) return true;
            visited[next] = false;
        }
        return false;
    }
}