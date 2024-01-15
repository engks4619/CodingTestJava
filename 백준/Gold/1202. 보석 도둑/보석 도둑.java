import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewelArr = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelArr[i] = new Jewel(weight, price);
        }
        Arrays.sort(jewelArr, Comparator.comparingInt(o -> o.weight));

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(bags);


        long maxPrice = 0;
        int jewelIdx = 0;
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
        for (int i = 0; i < K; i++) {
            while(jewelIdx < N && jewelArr[jewelIdx].weight <= bags[i]) {
                pq.offer(jewelArr[jewelIdx++]);
            }
            if(!pq.isEmpty()) {
                maxPrice += pq.poll().price;
            }
        }

        bw.write(maxPrice + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static class Jewel {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

    }
}