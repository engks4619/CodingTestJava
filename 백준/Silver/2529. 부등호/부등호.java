import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] selected;
    static char[] arr;
    static boolean[] visited;
    static Deque<String> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new char[N];
        selected = new int[N + 1];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        permutation(0);
        sb.append(queue.pollLast()).append("\n").append(queue.pollFirst()).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void permutation(int cnt) {
        if(cnt == N + 1){
            if(isValidExpression(selected)){
                StringBuilder tmp = new StringBuilder();
                Arrays.stream(selected).forEach(tmp::append);
                queue.offer(tmp.toString());
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if(visited[i]) continue;
            selected[cnt] = i;
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    static boolean isValidExpression(int[] selected){
        for (int i = 0; i < selected.length - 1; i++) {
            if(!checkLogic(selected[i], selected[i + 1], arr[i])) return false;
        }
        return true;
    }

    static boolean checkLogic(int a, int b, char c){
        if(c == '<') return a < b;
        else return a > b;
    }
}