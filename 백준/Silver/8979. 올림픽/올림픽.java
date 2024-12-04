import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(num, gold, silver, bronze));
        }
        Collections.sort(list);
        int rank = 1;
        if(list.get(0).num == K) rank = 1;
        else {
            for (int i = 1; i < N; i++) {
                Country curr = list.get(i);
                Country prev = list.get(i - 1);
                if(prev.gold == curr.gold
                        && prev.silver == curr.silver
                        && prev.bronze == curr.bronze) rank = i;
                else rank = i + 1;
                if(curr.num == K) break;
            }
        }
        System.out.println(rank);
        in.close();
    }

    static class Country implements Comparable<Country> {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if(this.gold != o.gold)
                return o.gold - this.gold;
            if(this.silver != o.silver)
                return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }
}