import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static long[] tree;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new long[4 * N];
        initTree(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            sb.append(getVal(1, 1, N, x, y)).append("\n");
            update(1, 1, N, a, b);
        }
        System.out.print(sb);
        in.close();
    }

    static long initTree(int node, int start, int end) {
        if(start == end)
            return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = initTree(node * 2, start, mid)
                + initTree(node * 2 + 1, mid + 1, end);
    }

    static long getVal(int node, int start, int end, int left, int right) {
        if(end < left || right < start)
            return 0;
        if(left <= start && end <= right)
            return tree[node];
        int mid = (start + end) / 2;
        return getVal(node * 2, start, mid, left, right)
                + getVal(node * 2 + 1, mid + 1, end, left, right);
    }

    static long update(int node, int start, int end, int idx, int val) {
        if(idx < start || idx > end)
            return tree[node];
        if(start == end)
            return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = update(node * 2, start, mid, idx, val)
                + update(node * 2 + 1, mid + 1, end, idx, val);
    }
}