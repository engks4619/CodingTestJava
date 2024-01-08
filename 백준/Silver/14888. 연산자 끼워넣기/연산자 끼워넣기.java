import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.function.BiFunction;

public class Main {

    static int N, minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
    static int[] numArr;
    static int[] opCntArr;
    static boolean[] visited;
    static List<Character> opCandidateList = new ArrayList<>();
    static char[] opArr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        numArr = new int[N];
        opCntArr = new int[N - 1];
        opArr = new char[N - 1];
        visited = new boolean[N - 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            while(cnt-- > 0) opCandidateList.add(operatorMap.get(i));
        }
        go(0);
        bw.write(maxSum + "\n" + minSum + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    static void go(int cnt){
        if(cnt == N - 1){
            updateSum();
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if(visited[i]) continue;
            opArr[cnt] = opCandidateList.get(i);
            visited[i] = true;
            go(cnt + 1);
            visited[i] = false;
        }
    }

    static void updateSum(){
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            stack.push(numArr[i]);
        }
        for (int i = 0; i < N - 1; i++) {
            int tmp = calculateMap.get(opArr[i]).apply(stack.pop(), stack.pop());
            stack.push(tmp);
        }
        int result = stack.pop();
        minSum = Math.min(minSum, result);
        maxSum = Math.max(maxSum, result);
    }

    static Map<Integer, Character> operatorMap = new HashMap<>();
    static{
        operatorMap.put(0, '+');
        operatorMap.put(1, '-');
        operatorMap.put(2, '*');
        operatorMap.put(3, '/');
    }

    static Map<Character, BiFunction<Integer, Integer, Integer>> calculateMap = new HashMap<>();
    static {
        calculateMap.put('+', (a, b) -> a + b);
        calculateMap.put('-', (a, b) -> a - b);
        calculateMap.put('*', (a, b) -> a * b);
        calculateMap.put('/', (a, b) -> a / b);
    }
}