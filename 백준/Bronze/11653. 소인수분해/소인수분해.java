import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        boolean[] primeArr = getPrimeArr((int)1e7);
        while(N > 1){
            for (int i = 2; i <= N; i++) {
                if(primeArr[i] && N % i == 0){
                    sb.append(i).append("\n");
                    N /= i;
                    break;
                }
            }
        }
        System.out.print(sb);
        in.close();
    }

    static boolean[] getPrimeArr(int max){
        boolean[] primeArr = new boolean[max + 1];
        Arrays.fill(primeArr, true);
        primeArr[0] = false;
        primeArr[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if(primeArr[i]){
                for (int j = i * i; j <= max; j += i) {
                    primeArr[j] = false;
                }
            }
        }
        return primeArr;
    }
}