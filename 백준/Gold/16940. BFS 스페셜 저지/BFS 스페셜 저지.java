import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] list;
    static int[] answerArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        list = new ArrayList[N + 1];
        answerArr = new int[N];
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
        int idx = 0;
        if(answerArr[idx++] != start) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            set.clear();
            int curr = queue.poll();
            for (int next : list[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                set.add(next);
            }
            for (int i = 0; i < set.size(); i++) {
                if (set.contains(answerArr[idx])) queue.offer(answerArr[idx++]);
                else return false;
            }
        }

        return true;
    }

}