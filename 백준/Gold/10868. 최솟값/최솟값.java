import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        int h = (int)(Math.ceil(Math.log(N) / Math.log(2))) + 1;
        int treeSize = (int)Math.pow(2, h + 1);
        tree = new int[treeSize];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        initTree(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(getMinValue(1, 1, N, l, r)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int initTree(int node, int left, int right) {
        if(left == right)
            return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int leftNode = initTree(node * 2, left, mid);
        int rightNode = initTree(node * 2 + 1, mid + 1, right);
        return tree[node] = Math.min(leftNode, rightNode);
    }

    static int getMinValue(int node, int start, int end, int left, int right) {
        if(right < start || end < left)
            return Integer.MAX_VALUE;
        if(left <= start && end <= right)
            return tree[node];
        int mid = (start + end) / 2;
        int leftNode = getMinValue(node * 2, start, mid, left, right);
        int rightNode = getMinValue(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(leftNode, rightNode);
    }

}