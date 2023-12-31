import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (nextPermutation()){
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach((num) -> sb.append(num).append(" "));
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        in.close();
    }

    static boolean nextPermutation(){
        // i 는 내림차순이 시작되는 첫번째 인덱스
        int i = N - 1;
        while (true){
            if(i == 0) return false; // 내림차순이 시작되는 첫번째 인덱스가 0번째라면 마지막 순열
            if(arr[i - 1] < arr[i]) break;
            i--;
        }
        // j 는 내림차순 시작 전 수(arr[i - 1])보다 큰 수 중 가장 작은 수의 인덱스
        int j = N - 1;
        while (true){
            if(arr[j] > arr[i - 1]) break;
            j--;
        }
        // 내림차순 시작 전 수와 그보다 바로 다음으로 큰 수를 변경하여 다음 수열 맞출 준비
        swap(i - 1, j);
        // 내림차순이던 수들을 오름차순으로 변경하여 바로 다음 수열로 맞춰주기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int k = i; k < N; k++) {
            pq.add(arr[k]);
        }
        for (int k = i; k < N; k++) {
            arr[k] = pq.poll();
        }
        return true;
    }

    static void swap(int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}