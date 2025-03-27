import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            Integer result = go(new StringTokenizer(in.readLine()), queue);
            if(result != null) sb.append(result).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static Integer go(StringTokenizer st, Deque<Integer> queue) {
        String operation = st.nextToken();
        switch (operation) {
            case "push":
                queue.offer(Integer.parseInt(st.nextToken()));
                return null;
            case "pop":
                return queue.isEmpty() ? -1 : queue.poll();
            case "size":
                return queue.size();
            case "empty":
                return queue.isEmpty() ? 1 : 0;
            case "front" :
                return queue.isEmpty() ? -1 : queue.peekFirst();
            case "back":
                return queue.isEmpty() ? -1 : queue.peekLast();
        }
        return null;
    }
}
