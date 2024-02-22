import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, S, arr[];
    
    static long cnt;
    static List<Integer> leftList = new ArrayList<>();
    static List<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        makeSumList(0, N / 2, 0, leftList);
        makeSumList(N / 2, N , 0, rightList);
        
        Collections.sort(leftList);
        Collections.sort(rightList);
        
        updateTotalCnt();
        if(S == 0) cnt--;
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }
    
    static void updateTotalCnt() {
        int left = 0;
        int right = rightList.size() - 1;
        
        while(left < leftList.size() && right >= 0) {
            int a = leftList.get(left);
            int b = rightList.get(right);
            long sum = a + b;
            if(sum == S) {
                long aCnt = 0;
                while(left < leftList.size() && leftList.get(left) == a) {
                    left++;
                    aCnt++;
                }
                long bCnt = 0;
                while(right >= 0 && rightList.get(right) == b) {
                    right--;
                    bCnt++;
                }
                cnt += aCnt * bCnt;
            }
            else if(sum < S) left++;
            else right--;
        }
    }

    static void makeSumList(int idx, int end, int sum, List<Integer> list) {
        if(idx == end) {
            list.add(sum);
            return;
        }
        makeSumList(idx + 1, end, sum + arr[idx], list);
        makeSumList(idx + 1, end, sum, list);
    }

}