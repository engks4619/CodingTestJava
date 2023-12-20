import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int lcm = A * B / gcd(A, B);
            sb.append(lcm).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}