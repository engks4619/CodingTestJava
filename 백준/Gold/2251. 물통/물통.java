import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int[] limit = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][][] visited = new boolean[limit[0] + 1][limit[1] + 1][limit[2] + 1];
        Set<Integer> set = new HashSet<>();
        Queue<Bucket> queue = new ArrayDeque<>();
        queue.offer(new Bucket(new int[] {0, 0, limit[2]}));
        visited[0][0][limit[2]] = true;
        set.add(limit[2]);
        while(!queue.isEmpty()) {
            Bucket curr = queue.poll();
            if(curr.amount[0] == 0) set.add(curr.amount[2]);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    Bucket next = move(curr, i, j);
                    if(!visited[next.amount[0]][next.amount[1]][next.amount[2]]) {
                        visited[next.amount[0]][next.amount[1]][next.amount[2]] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList(set);
        Collections.sort(list);
        for(int num : list){
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static Bucket move(Bucket bucket, int from, int to) {
        int[] amount = bucket.amount.clone();
        int water = limit[to] < amount[from] + amount[to] ? limit[to] - amount[to] : amount[from];
        amount[from] -= water;
        amount[to] += water;
        return new Bucket(amount);
    }

    static class Bucket {
        int[] amount;

        public Bucket(int[] bucket) {
            this.amount = bucket;
        }

    }

}