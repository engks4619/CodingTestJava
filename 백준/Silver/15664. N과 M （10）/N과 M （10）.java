import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;
    static LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        go(0, 0);
        linkedHashSet.forEach((e) -> sb.append(e).append("\n"));
        System.out.print(sb);
        in.close();
    }

    static void go(int idx, int cnt){
        if(cnt == M){
            StringBuilder tmp = new StringBuilder();
            Arrays.stream(selected).forEach((num) -> tmp.append(num).append(" "));
            linkedHashSet.add(tmp.toString());
            return;
        }
        for (int i = idx; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = arr[i];
            go(i + 1, cnt + 1);
            visited[i] = false;
        }

    }
}