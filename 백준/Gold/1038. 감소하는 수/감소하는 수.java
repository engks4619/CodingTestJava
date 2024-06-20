import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Long> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        for (int i = 0; i < 10; i++) {
            go(1, i);
        }
        Collections.sort(list);
        System.out.println(N >= list.size() ? -1 : list.get(N));
        in.close();
    }

    static void go(int cnt, long num) {
        if(cnt > 10) return; //9876543210
        list.add(num);
        for (int i = 0; i < 10; i++) {
            if(num % 10 <= i) continue;
            go(cnt + 1, num * 10 + i);
        }
    }

}