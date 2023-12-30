import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int answer = 0;
        int upValue = 1;
        int flag = 10;
        for (int i = 1; i <= N; i++) {
            if(i == flag){
                flag *= 10;
                upValue++;
            }
            answer += upValue;
        }
        System.out.println(answer);
        in.close();
    }
}