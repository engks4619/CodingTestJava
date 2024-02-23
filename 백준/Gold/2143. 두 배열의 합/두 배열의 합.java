import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        int N = Integer.parseInt(in.readLine());
        int[] leftArr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            leftArr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        int[] rightArr = new int[M];
        for (int i = 0; i < M; i++) {
            rightArr[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> leftList = makeSumList(N, leftArr);
        List<Long> rightList = makeSumList(M, rightArr);

        Collections.sort(leftList);
        Collections.sort(rightList);

        long cnt = getCnt(leftList, rightList, T);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static long getCnt(List<Long> leftList, List<Long> rightList, int T) {
        long cnt = 0;
        int left = 0;
        int right = rightList.size() - 1;
        while(left < leftList.size() && right >= 0) {
            long a = leftList.get(left);
            long b = rightList.get(right);
            long sum = a + b;
            if(sum == T) {
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
            else if (sum < T) left++;
            else right--;
        }
        return cnt;
    }

    static List<Long> makeSumList(int size, int[] arr) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
        return list;
    }

}