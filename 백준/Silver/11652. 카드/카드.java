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
            if(cntMap.get(key) > maxCnt) {
                answer = key;
                maxCnt = cntMap.get(key);
            } else if (cntMap.get(key) == maxCnt)
                answer = Math.min(answer, key);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

}