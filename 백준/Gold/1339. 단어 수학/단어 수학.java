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
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = str.length() - 1; j >= 0; j--) {
                char c = str.charAt(j);
                cntMap.put(c, cntMap.getOrDefault(c, 0) + (int) Math.pow(10, str.length() - 1 - j));
            }
        }
        List<Integer> cntList = new ArrayList<>(cntMap.values());
        Collections.sort(cntList, Collections.reverseOrder());
        int sum = 0;
        int num = 9;
        for(int cnt : cntList){
            sum += num * cnt;
            num--;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        in.close();
    }


}