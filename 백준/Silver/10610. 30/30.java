import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        String str = in.readLine();
        boolean zeroFlag = false;
        for(char c : str.toCharArray()) {
            pq.offer(c - '0');
            if(c == '0') zeroFlag = true;
        }
        String answer = "-1";
        if(zeroFlag) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            while(!pq.isEmpty()) {
                int num = pq.poll();
                sum += num;
                sb.append(num);
            }
            if(sum != 0 && sum % 3 == 0) answer = sb.toString();
        }
        bw.write(answer);
        bw.flush();
        bw.close();
        in.close();
    }
}