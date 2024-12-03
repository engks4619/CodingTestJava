import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(in.readLine()));
        }
        int M = (int) Math.round(N * 0.15);
        int sum = 0;
        for (int i = 0; i < N - M; i++) {
            if(pq.isEmpty()) break;
            if(i < M) pq.poll();
            else sum += pq.poll();
        }
        System.out.println(Math.round((float) sum / (N - 2 * M)));
        in.close();
    }
}