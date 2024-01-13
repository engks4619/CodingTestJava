import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int minCnt = Integer.MAX_VALUE;
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        initPrimeArr();
        int TC = Integer.parseInt(in.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(bfs(A, B)) sb.append(minCnt);
            else sb.append("Impossible");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        in.close();
    }

    static void initPrimeArr() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            for (int j = i * i; j < 10000; j+= i) {
                isPrime[j] = false;
            }
        }
    }

    static boolean bfs(String A, String B) {
        Queue<String> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        for (int i = 0; i <= 999; i++) {
            visited[i] = true;
        }
        queue.offer(A);
        visited[Integer.parseInt(A)] = true;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if(curr.equals(B)) {
                    minCnt = cnt;
                    return true;
                }
                for (int j = 0; j < curr.length(); j++) {
                    for (int k = 0; k <= 9; k++) {
                        StringBuilder nextSb = new StringBuilder(curr);
                        nextSb.setCharAt(j, (char) (k + '0'));
                        String next = nextSb.toString();
                        if(!visited[Integer.parseInt(next)] && isPrime[Integer.parseInt(next)]){
                            visited[Integer.parseInt(next)] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
            cnt++;
        }
        return false;
    }

}