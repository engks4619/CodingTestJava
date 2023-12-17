import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long num1 = Long.parseLong(st.nextToken() + st.nextToken());
        long num2 = Long.parseLong(st.nextToken() + st.nextToken());
        System.out.println(num1 + num2);
        in.close();
    }
}