import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 1; i <= N; i++) {
            deque.add(new int[] {i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()){
            int[] curr = deque.pollFirst();
            int num = curr[1];
            sb.append(curr[0]).append(" ");

            if(deque.isEmpty()) break;

            if(num < 0) {
                for (int i = 0; i < Math.abs(num); i++) {
                    deque.addFirst(deque.pollLast());
                }
            } else {
                for (int i = 1; i < num; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
        }
        
        System.out.println(sb);
        in.close();
    }
}
