import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        if(N == 0) sb.append(0);
        while (N != 0){
            int r = N % -2;
            N /= -2;
            if (r == -1){
                r = 1;
                N++;
            }
            sb.append(r);
        }
        System.out.println(sb.reverse());
        in.close();
    }
}