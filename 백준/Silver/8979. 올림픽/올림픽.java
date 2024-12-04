import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];
        int target = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(num, gold, silver, bronze);
            if(num == K) target = i;
        }
        int rank = 1;
        Country k = countries[target];
        for (int i = 0; i < N; i++) {
            Country c = countries[i];
            if(c.gold > k.gold
                    || (c.gold == k.gold && c.silver > k.silver)
                    || (c.gold == k.gold && c.silver == k.silver && c.bronze > k.bronze)) rank++;
        }
        System.out.println(rank);
        in.close();
    }

    static class Country {
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
    }

}