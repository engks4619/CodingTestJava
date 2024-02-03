import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int min = Math.min(X, Y);
        int price = Math.min(A * min + B * min, C * 2 * min);
        int remain = Math.abs(X - Y);
        price += min != X ? Math.min(C * 2 * remain, A * remain) : Math.min(C * 2 * remain, B * remain);
        bw.write(price + "\n");
        bw.flush();
        bw.close();
        in.close();
    }
    
}