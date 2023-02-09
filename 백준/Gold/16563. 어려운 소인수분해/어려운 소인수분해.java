import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] primeArr = new int[5000001];
        boolean[] isPrime = new boolean[5000001];
        int idx = 0;
        for (int i = 2; i < 2500001; i++) {
            if (!isPrime[i]) {
                primeArr[idx++] = i;
                for (int j = 2; j * i < 5000001; j++) {
                    isPrime[j * i] = true;
                }
            }
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            while (num > 1) {
                if (isPrime[num]) {
                    for (int i = 0; i < idx; i++) {
                        if (num % primeArr[i] == 0) {
                            sb.append(primeArr[i]).append(" ");
                            num /= primeArr[i];
                            break;
                        }
                    }
                } else {
                    sb.append(num).append(" ");
                    num = 1;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}