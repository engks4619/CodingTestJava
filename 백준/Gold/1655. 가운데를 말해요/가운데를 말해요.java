import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            if(i % 2 == 0) maxQueue.offer(num);
            else minQueue.offer(num);
            if(!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                maxQueue.offer(minQueue.poll());
                minQueue.offer(maxQueue.poll());
            }
            sb.append(maxQueue.peek()).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

}