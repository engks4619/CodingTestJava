import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = (int) 1e9;
    static int N, M, X;
    static ArrayList<int[]>[] arrList;
    static ArrayList<int[]>[] backArrList;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[N+1];
        backArrList = new ArrayList[N+1];
        for(int i = 1 ; i <= N; i++){
            arrList[i] = new ArrayList<>();
            backArrList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arrList[from].add(new int[] {to, time});
            backArrList[to].add(new int[] {from, time});
        }
        int[] toDist = dijkstra(arrList);
        int[] backDist = dijkstra(backArrList);
        int maxTime = 0;
        for(int i = 1; i <= N; i++){
            maxTime = Math.max(maxTime, toDist[i] + backDist[i]);
        }
        System.out.println(maxTime);
        in.close();
    }

    static int[] dijkstra(ArrayList<int[]>[] arr){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        boolean[] visited = new boolean[N+1];
        pq.offer(new int[]{X, 0});
        dist[X] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int nextNode = curr[0];
            if(visited[nextNode]) continue;
            visited[nextNode] = true;
            for(int[] nextArr : arr[nextNode]){
                int next = nextArr[0];
                int distance = nextArr[1];
                // 중간을 거쳐 가는 게 더 빠른 경우
                if(dist[next] > dist[nextNode] + distance){
                    dist[next] = dist[nextNode] + distance;
                    pq.offer(new int[] {next, dist[next]});
                }
            }
        }

        return dist;
    }
}