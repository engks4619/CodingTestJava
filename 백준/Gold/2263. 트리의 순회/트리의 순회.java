import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] inOrder, postOrder, inOrderIdxArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        inOrderIdxArr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            inOrderIdxArr[inOrder[i]] = i;
        }
        go(0, N - 1, 0, N - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return;
        int root = postOrder[pe];
        sb.append(root).append(" ");
        int rootIdx = inOrderIdxArr[root];
        go(is, rootIdx - 1, ps, ps + rootIdx - is - 1);
        go(rootIdx + 1, ie, ps + rootIdx - is, pe - 1);
    }
    
}