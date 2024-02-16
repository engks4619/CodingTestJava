import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, maxCnt;
    static Egg[] eggArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        eggArr = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggArr[i] = new Egg(d, w);
        }
        go(0, 0);
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int idx, int cnt) {
        if(maxCnt == N) return;
        if(idx == N) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        Egg curr = eggArr[idx];
        if(curr.durability <= 0 || cnt == N - 1) {
            go(idx + 1, cnt);
            return;
        }
        int nCnt = cnt;
        for (int i = 0; i < N; i++) {
            if(i == idx || eggArr[i].durability <= 0) continue;
            curr.durability -= eggArr[i].weight;
            eggArr[i].durability -= curr.weight;
            if(curr.durability <= 0) nCnt++;
            if(eggArr[i].durability <= 0) nCnt++;
            go(idx + 1, nCnt);
            curr.durability += eggArr[i].weight;
            eggArr[i].durability += curr.weight;
            nCnt = cnt;
        }
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

}