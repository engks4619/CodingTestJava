import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
        if (prevPermutation()){
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach((num) -> sb.append(num).append(" "));
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        in.close();
    }

    static boolean prevPermutation(){
        int i = N - 1;
        while (true){
            if(i == 0) return false;
            if(arr[i - 1] > arr[i]) break;
            i--;
        }
        int j = N - 1;
        while (true){
            if(arr[j] < arr[i - 1]) break;
            j--;
        }
        swap(i - 1, j);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
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