import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, minTree, maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int treeCnt = (int) Math.pow(2, h);
        minTree = new int[treeCnt];
        maxTree = new int[treeCnt];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        initTree("min", minTree, 1, 1, N);
        initTree("max", maxTree, 1, 1, N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(getValue("min", l, r, 1, 1, N)).append(" ");
            sb.append(getValue("max", l, r, 1, 1, N)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void initTree(String type, int[] tree, int node, int left, int right) {
        if(left == right) {
            tree[node] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        initTree(type, tree, node * 2, left, mid);
        initTree(type, tree, node * 2 + 1, mid + 1, right);
        if(type.equals("min"))
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        else
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    static int getValue(String type, int left, int right, int node, int leftNode, int rightNode) {
        // 탐색 범위를 벗어나는 경우
        if(right < leftNode || rightNode < left)
            return type.equals("min") ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if(left <= leftNode && rightNode <= right)
            return type.equals("min") ? minTree[node] : maxTree[node];
        int mid = (leftNode + rightNode) / 2;
        int leftNodeVal = type.equals("min") ?
                getValue("min", left, right, node * 2, leftNode, mid)
                : getValue("max", left, right, node * 2, leftNode, mid);
        int rightNodeVal = type.equals("min") ?
                getValue("min", left, right, node * 2 + 1, mid + 1, rightNode)
                : getValue("max", left, right, node * 2 + 1, mid + 1, rightNode);
        return type.equals("min") ?
                Math.min(leftNodeVal, rightNodeVal)
                : Math.max(leftNodeVal, rightNodeVal);
    }

}