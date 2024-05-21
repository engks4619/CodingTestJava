import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K, arr[];
    static List<Integer>[] level;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(in.readLine());
        level = new List[K];
        for (int i = 0; i < K; i++) {
            level[i] = new ArrayList<>();
        }
        arr = new int[(1 << K) - 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr.length - 1, 0);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : level) {
            for(int node : list) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void dfs(int s, int e, int depth) {
        if(s > e) return;
        int mid = (s + e) / 2;
        level[depth].add(arr[mid]);
        dfs(s, mid - 1, depth + 1);
        dfs(mid + 1, e, depth + 1);
    }

}