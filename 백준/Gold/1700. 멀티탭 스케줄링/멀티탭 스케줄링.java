import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] order = new int[K];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] isUsed = new boolean[101];
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int currOrder = order[i];
            if(isUsed[currOrder]) continue; // 이미 사용 중인 경우
            if(cnt < N) { // 빈 공간 있는 경우
                isUsed[currOrder] = true;
                cnt++;
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < K; j++) {
                int num = order[j];
                if(isUsed[num] && !list.contains(num)) list.add(num);
            }
            if(list.size() != N) {
                for (int j = 0; j < K; j++) {
                    if(isUsed[j] && !list.contains(j)) {
                        isUsed[j] = false;
                        break;
                    }
                }
            }else {
                isUsed[list.get(list.size() - 1)] = false;
            }
            isUsed[currOrder] = true;
            answer++;
        }
        System.out.println(answer);
        in.close();
    }

}