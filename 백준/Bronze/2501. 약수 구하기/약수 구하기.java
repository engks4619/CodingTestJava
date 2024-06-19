import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= N; i++) {
            if(N % i == 0) {
                if(i * i != N) list.add(N / i);
                list.add(i);
            }
        }
        Collections.sort(list);
        System.out.println(K > list.size() ? 0 : list.get(K - 1));
        in.close();
    }
}