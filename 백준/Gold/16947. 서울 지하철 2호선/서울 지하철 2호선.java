import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] isCycle, visited;
    static int[] distArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        list = new ArrayList[N + 1];
        distArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        isCycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if(checkCycle(0, i, i)) break;
            visited = new boolean[N + 1];
        }

        updateDistArr();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(distArr[i]).append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean checkCycle(int prev, int curr, int start){
        visited[curr] = true;
        for(int next : list[curr]){
            if(visited[next]){
                //next를 이미 방문한 상태에서 prev != next 라면 prev가 아닌 다른 노드에서 next를 접근했었음을 의미
                // => 싸이클 발생
                //next == start 면 다음 노드가 첫 노드이므로 dfs 탐색에서 사이클의 끝(마지막 노드)이라는 의미
                if(prev != next && next == start) {
                    isCycle[next] = true;
                    return true;
                }
                continue;
            }
            if(checkCycle(curr, next, start)) {
                isCycle[next] = true;
                return true;
            }

        }
        return false;
    }

    //bfs 탐색으로 배열에 거리정보 업데이트
    static void updateDistArr(){
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        // 싸이클(순환선)에 포함된 노드를 기준으로 BFS 탐색
        for (int i = 1; i <= N; i++) {
            if(!isCycle[i]) continue;
            visited[i] = true;
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for (int next : list[curr]){
                if(visited[next]) continue;
                visited[next] = true;
                distArr[next] = distArr[curr] + 1;
                queue.offer(next);
            }
        }
    }
}