import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        sb.append((1 << N) - 1).append("\n");
        go(N, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int N, int start, int mid, int end) {
        if(N == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        go(N - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        go(N - 1, mid, start, end);
    }

}