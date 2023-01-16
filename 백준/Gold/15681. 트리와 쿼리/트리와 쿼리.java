import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list[], tree[];
    static int parent[], size[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        tree = new ArrayList[N+1];
        parent = new int[N+1];
        size = new int[N+1];
        
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(in.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list[U].add(V);
            list[V].add(U);
        }
        makeTree(R, -1);
        countSubtreeNodes(R);
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            int q = Integer.parseInt(in.readLine());
            sb.append(size[q]).append("\n");
        }
        System.out.println(sb);
        in.close();
    }

    public static void makeTree(int curr, int p){
        for(int node : list[curr]){
            if(node != p){
                tree[curr].add(node);
                parent[node] = curr;
                makeTree(node, curr);
            }
        }
    }

    public static void countSubtreeNodes(int curr){
        size[curr] = 1;
        for(int node: tree[curr]){
            countSubtreeNodes(node);
            size[curr] += size[node];
        }
    }

}