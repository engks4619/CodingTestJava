import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static long[] tree;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int treeCnt = (int)Math.pow(2, h + 1);
        tree = new long[treeCnt];
        StringBuilder sb = new StringBuilder();
        initTree(1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1) {
                arr[b] = c;
                update(1, 1, N, b, c);
            }else if(a == 2){
                sb.append(getVal(1, 1, N, b, (int) c)).append("\n");
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
        return tree[node] = (leftNode * rightNode) % MOD;
    }

    static long update(int node, int start, int end, int idx, long val) {
        if(idx < start || end < idx)
            return tree[node];
        if(start == end)
            return tree[node] = val;
        int mid = (start + end) / 2;
        long leftNode = update(node * 2, start, mid, idx, val);
        long rightNode = update(node * 2 + 1, mid + 1, end, idx, val);
        return tree[node] = (leftNode * rightNode) % MOD;
    }

    static long getVal(int node, int start, int end, int left, int right) {
        if(left > end || right < start)
            return 1;
        if(left <= start && end <= right)
            return tree[node];
        int mid = (start + end) / 2;
        long leftNode = getVal(node * 2, start, mid, left, right);
        long rightNode = getVal(node * 2 + 1, mid + 1, end, left, right);
        return (leftNode * rightNode) % MOD;
    }

}