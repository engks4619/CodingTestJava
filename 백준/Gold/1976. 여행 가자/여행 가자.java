import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }
        st = new StringTokenizer(in.readLine());
        boolean flag = true;
        int root = find(Integer.parseInt(st.nextToken()) - 1);
        for (int i = 0; i < M - 1; i++) {
            if (find(Integer.parseInt(st.nextToken()) - 1) != root) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
        in.close();
    }

    static int find(int a) {
        if(a == parents[a]) return a;
        return find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
}