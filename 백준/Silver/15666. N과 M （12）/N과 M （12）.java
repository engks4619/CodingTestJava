import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Integer[] arr;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = set.toArray(new Integer[set.size()]);
        Arrays.sort(arr);
        go(0, 0);
        System.out.print(sb);
        in.close();
    }

    static void go(int idx, int cnt){
        if(cnt == M){
            Arrays.stream(selected).forEach((num) -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            selected[cnt] = arr[i];
            go(i, cnt + 1);
        }
    }
}