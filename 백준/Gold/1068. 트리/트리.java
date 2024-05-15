import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, leafNodeCnt;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        parents = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        int root = -2;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            parents[i] = num;
            if(num == -1) root = i;
        }
        int deletedNode = Integer.parseInt(in.readLine());
        deleteNode(deletedNode);
        updateLeafNodeCnt(root);
        System.out.println(leafNodeCnt);
        in.close();
    }

    static void deleteNode(int idx) {
        parents[idx] = -2;
        for (int i = 0; i < N; i++) {
            if(parents[i] == idx) deleteNode(i);
        }
    }

    static void updateLeafNodeCnt(int idx) {
        boolean isLeafNode = true;
        visited[idx] = true;
        if(parents[idx] == -2) return;
        for (int i = 0; i < N; i++) {
            if(parents[i] == idx && !visited[i]) {
                isLeafNode = false;
                updateLeafNodeCnt(i);
            }
        }
        if(isLeafNode) leafNodeCnt++;
    }

}