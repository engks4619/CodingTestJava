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
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Time(s, e));
        }
        int cnt = 0;
        int currTime = 0;
        while(!pq.isEmpty()) {
            Time curr = pq.poll();
            if(currTime <= curr.startTime) {
                currTime = curr.endTime;
                cnt++;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static class Time implements Comparable<Time> {
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time o) {
            return this.endTime - o.endTime == 0 ? this.startTime - o.startTime : this.endTime - o.endTime;
        }
    }
}