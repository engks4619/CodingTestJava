package baekjoon.day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_11286_절댓값_힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) != Math.abs(o2) ? Math.abs(o1) - Math.abs(o2) : o1 - o2);
        for (int tc = 0; tc < N; tc++) {
            int num = Integer.parseInt(in.readLine());
            if (num != 0)
                pq.add(num);
            else {
                sb.append(pq.peek() != null ? pq.poll() : 0);
                sb.append("\n");
            }
        }
        System.out.println(sb);
        in.close();
    }


}
