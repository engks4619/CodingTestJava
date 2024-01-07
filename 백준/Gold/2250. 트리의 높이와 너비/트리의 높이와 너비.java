import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node> tree = new ArrayList<>();
    static int[] levelMin;
    static int[] levelMax;
    static int maxLevel = 0;
    static int xIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int rootIdx = 0;
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new Node(i, -1, -1));
            levelMin[i] = N;
            levelMax[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int curr = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.get(curr).left = left;
            tree.get(curr).right = right;
            if(left != -1) tree.get(left).parent = curr;
            if(right != -1) tree.get(right).parent = curr;
        }

        for (int i = 1; i <= N; i++) {
            if(tree.get(i).parent == -1) {
                rootIdx = i;
                break;
            }
        }

        inOrder(rootIdx, 1);

        int level = 1;
        int width = 1;
        for (int i = 1; i <= maxLevel; i++) {
            int tmpWidth = levelMax[i] - levelMin[i] + 1;
            if(width < tmpWidth){
                level = i;
                width = tmpWidth;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(" ").append(width).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void inOrder(int rootIdx, int level){
        Node root = tree.get(rootIdx);
        maxLevel = Math.max(maxLevel, level);
        if(root.left != -1) inOrder(root.left, level + 1);
        levelMin[level] = Math.min(levelMin[level], xIdx);
        levelMax[level] = Math.max(levelMax[level], xIdx);
        xIdx++;
        if(root.right != -1) inOrder(root.right, level + 1);
    }

    static class Node {
        int parent;
        int curr;
        int left;
        int right;

        public Node(int curr, int left, int right) {
            this.parent = -1;
            this.curr = curr;
            this.left = left;
            this.right = right;
        }
    }
}