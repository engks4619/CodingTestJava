import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, idx;
    static ArrayList<Integer>[] list;
    static int[] answerArr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        answerArr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            answerArr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(checkCorrect() ? 1 : 0).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean checkCorrect(){
        int start = 1;
        idx = 0;
        if(answerArr[idx++] != start) return false;
        visited = new boolean[N + 1];
        return dfs(start);
    }

    static boolean dfs(int curr){
        visited[curr] = true;
        Set<Integer> set = new HashSet<>();
        for (int next : list[curr]) {
            if(visited[next]) continue;
            set.add(next);
        }

        if(set.isEmpty()) return true;

        if(set.contains(answerArr[idx]) && dfs(answerArr[idx++])) return true;
        else return false;
    }

}