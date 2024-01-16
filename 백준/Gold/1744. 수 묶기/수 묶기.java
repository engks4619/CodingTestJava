import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            if(num <= 0) minusPQ.offer(num);
            else plusPQ.offer(num);
        }
        go(minusPQ);
        go(plusPQ);
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(PriorityQueue<Integer> pq) {
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(!pq.isEmpty()) {
                int b = pq.poll();
                sum += Math.max(a * b, a + b);
            }
            else sum += a;
        }
    }

}