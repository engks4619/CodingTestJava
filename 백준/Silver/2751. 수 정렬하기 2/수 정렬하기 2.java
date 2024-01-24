import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        boolean[] arr = new boolean[(int) 2e6 + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            arr[num + (int) 1e6] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= (int) 2e6; i++) {
            if(arr[i]) sb.append(i - (int) 1e6).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }
}