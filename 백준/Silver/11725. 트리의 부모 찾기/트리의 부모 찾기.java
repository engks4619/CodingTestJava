import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] tree;
    static int[] parentArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        tree = new ArrayList[N + 1];
        parentArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }
        go(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parentArr[i]).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        in.close();
    }

    static void go(int s){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(Integer next : tree[curr]){
                if(parentArr[next] != 0) continue;
                parentArr[next] = curr;
                queue.offer(next);
            }
        }
    }
}