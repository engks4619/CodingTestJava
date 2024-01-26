import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(in.readLine());
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int maxCnt = 0;
        long answer = Long.MAX_VALUE;
        for(Long key : cntMap.keySet()) {
            int cnt = cntMap.get(key);
            if(cnt >= maxCnt) {
                answer = cntMap.get(key) == maxCnt ? Math.min(answer, key) : key;
                maxCnt = cnt;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

}