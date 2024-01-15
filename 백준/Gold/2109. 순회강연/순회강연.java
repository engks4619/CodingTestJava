import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        boolean[] visited = new boolean[10001];
        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) ->
                o1.price != o2.price ? o2.price - o1.price : o1.day - o2.day);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int price = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(price, day));
        }
        int maxPrice = 0;
        while(!pq.isEmpty()) {
            Lecture curr = pq.poll();
            for (int day = curr.day; day >= 1; day--) {
                if(!visited[day]){
                    visited[day] = true;
                    maxPrice += curr.price;
                    break;
                }
            }
        }
        bw.write(maxPrice + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static class Lecture {
        int price;
        int day;

        public Lecture(int price, int day) {
            this.price = price;
            this.day = day;
        }

    }
}