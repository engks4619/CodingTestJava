import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(set.contains(Integer.parseInt(st.nextToken()))? "1" : 0).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }
}