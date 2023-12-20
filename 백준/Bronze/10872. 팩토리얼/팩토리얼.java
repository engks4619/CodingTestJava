import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        System.out.println(factorial(N));
        in.close();
    }

    static int factorial(int num){
        int res = 1;
        for (int i = 2; i <= num; i++){
            res *= i;
        }
        return res;
    }
}