import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(in.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        System.out.println(getCnt(a, b, 0));
        in.close();
    }

    static int getCnt(int curr, int parent, int cnt) {
        if(curr == parent) {
            return cnt;
        }
        visited[curr] = true;
        for(int next : graph[curr]) {
            if(!visited[next]) {
                int tmpCnt = getCnt(next, parent, cnt + 1);
                if(tmpCnt != -1) return tmpCnt;
            }
        }
        return -1;
    }
}