import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        List<Integer> primeList = getPrimeList(N);
        int cnt = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(l <= r && r < primeList.size()) {
            if(sum == N) cnt++;
            if(sum < N) sum += primeList.get(r++);
            else sum -= primeList.get(l++);
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static List<Integer> getPrimeList(int N) {
        boolean[] isPrime = new boolean[N + 1];
        List<Integer> primeList = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(isPrime[i]) primeList.add(i);
        }
        primeList.add(0);
        return primeList;
    }

}