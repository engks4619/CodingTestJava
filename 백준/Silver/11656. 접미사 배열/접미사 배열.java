import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < S.length(); i++) {
            pq.offer(S.substring(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}