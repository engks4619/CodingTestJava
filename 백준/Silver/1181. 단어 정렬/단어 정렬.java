import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() - o2.length() == 0) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        int N = Integer.parseInt(in.readLine());
        while(N-- > 0){
            queue.offer(in.readLine());
        }
        String prev = queue.poll();
        System.out.println(prev);
        while(!queue.isEmpty()){
            String next = queue.poll();
            if(prev.equals(next)) continue;
            prev = next;
            System.out.println(next);
        }

        in.close();
    }
}