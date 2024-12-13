import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] cardArr = new int[N];
        int[] scoreArr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, cardArr[i]);
        }
        int[] posArr = new int[max + 1];
        for (int i = 0; i < N; i++) {
            posArr[cardArr[i]] = i + 1;
        }
        for(int num : cardArr) {
            for (int i = num * 2; i <= max; i += num) {
                if(posArr[i] != 0) {
                    scoreArr[posArr[i]]--;
                    scoreArr[posArr[num]]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(scoreArr[i]).append(" ");
        }
        System.out.println(sb);
        in.close();
    }
}