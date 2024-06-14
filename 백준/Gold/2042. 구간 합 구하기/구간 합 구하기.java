import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(in.readLine());
        }
        tree = new long[4 * N];
        initTree(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1) {
                // swap b,c
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, N, b, diff);
            }
            else {
                // sum b ~ c
                sb.append(getSum(1, 1, N, b, (int) c)).append("\n");
            }
        }
        System.out.print(sb);
        in.close();
    }

    static long initTree(int node, int start, int end) {
        if(start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        long leftNode = initTree(node * 2, start, mid);
        long rightNode = initTree(node * 2 + 1, mid + 1, end);
        return tree[node] = leftNode + rightNode;
    }

    static long getSum(int node, int start, int end, int left, int right) {
        if(right < start || left > end)
            return 0;
        if(left <= start && end <= right)
            return tree[node];
        int mid = (start + end) / 2;
        return getSum(node * 2, start, mid, left, right)
                + getSum(node * 2 + 1, mid + 1, end, left, right);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if(idx < start || idx > end)
            return;
        tree[node] += diff;
        if(start == end)
            return;
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

}