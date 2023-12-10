import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]> arrList[];
    static boolean[] visited;
    static int V, result, maxV;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(in.readLine());
        arrList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            arrList[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                arrList[from].add(new int[] {to, dist});
            }
        }
        go(1, 0);
        visited = new boolean[V + 1];
        go(maxV, 0);
        System.out.println(result);
        in.close();
    }

    static void go(int node, int dist){
        if(dist > result){
            result = dist;
            maxV = node;
        }
        visited[node] = true;
        for(int[] nextArr: arrList[node]){
            int nextNode = nextArr[0];
            int distance = nextArr[1];
            if(visited[nextNode]) continue;
            go(nextNode, dist + distance);
        }
    }
}