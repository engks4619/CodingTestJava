import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 0;
        int maxNum = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        while((N = Integer.parseInt(in.readLine())) != 0){
            queue.offer(N);
            maxNum = Math.max(maxNum, N);
        }
        boolean[] primeArr = getPrimeArr(maxNum);

        while(!queue.isEmpty()){
            int num = queue.poll();
            boolean flag = false;
            for (int i = 3; i <= num / 2; i++) {
                if(primeArr[i] && primeArr[num - i]){
                    flag = true;
                    sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append("\n");
                    break;
                }
            }
            if(!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.print(sb);
        in.close();
    }

    static boolean[] getPrimeArr(int max){
        boolean[] primeArr = new boolean[max + 1];
        Arrays.fill(primeArr, true);
        primeArr[0] = false;
        primeArr[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if(primeArr[i]){
                for (int j = i * i; j <= max; j += i) {
                    primeArr[j] = false;
                }
            }
        }
        return primeArr;
    }
}