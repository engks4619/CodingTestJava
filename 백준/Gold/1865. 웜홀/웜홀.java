import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Vertex>[] list;
    static int INF = (int)1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(in.readLine());
        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(in.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(i < M) {
                    list[S].add(new Vertex(E, T));
                    list[E].add(new Vertex(S, T));
                } else {
                    list[S].add(new Vertex(E, -T));
                }
            }
            if(isCycle()) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static boolean isCycle() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for(Vertex next : list[j]) {
                    if(dist[next.dest] > dist[j] + next.time) {
                        if(i == N) return true;
                        dist[next.dest] = dist[j] + next.time;
                    }
                }
            }
        }
        return false;
    }

    static class Vertex {
        int dest;
        int time;

        public Vertex(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

    }
}