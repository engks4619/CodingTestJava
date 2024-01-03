import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static int[] colorArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(K-- > 0){
            st = new StringTokenizer(in.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }
            sb.append(check() ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static boolean check(){
        colorArr = new int[list.length];
        for (int i = 1; i < list.length - 1; i++) {
            if(colorArr[i] == 0){
                if(!dfs(i, 1)) return false;
            }
        }
        return true;
    }

    static boolean dfs(int idx, int color){
        colorArr[idx] = color;
        for(int next : list[idx]){
            if(colorArr[next] == color) return false;
            if(colorArr[next] == 0){
                if(!dfs(next, color * -1)) return false;
            }
        }
        return true;
    }
}