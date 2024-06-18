import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int num = 666;
        int cnt = 1;
        while(cnt != N) {
            num++;
            if(String.valueOf(num).contains("666")) cnt++;
        }
        System.out.println(num);
        in.close();
    }
}