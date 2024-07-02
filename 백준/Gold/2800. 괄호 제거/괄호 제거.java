import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static char[] arr;
    static boolean[] selected;
    static List<int[]> bracketList = new ArrayList<>();
    static Set<String> answer = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        arr = input.toCharArray();
        N = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(arr[i] == '(') stack.push(i);
            else if(arr[i] == ')') {
                bracketList.add(new int[] {stack.pop(), i});
            }
        }
        selected = new boolean[bracketList.size()];
        go(0);
        answer.remove(input);
        StringBuilder sb = new StringBuilder();
        for (String str : answer) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static void go(int depth) {
        if(depth == selected.length){
            StringBuilder sb = new StringBuilder();
            boolean[] isRemove = new boolean[N];
            for (int i = 0; i < selected.length; i++) {
                if(selected[i]) {
                    int[] pos = bracketList.get(i);
                    isRemove[pos[0]] = true;
                    isRemove[pos[1]] = true;
                }
            }

            for (int i = 0; i < N; i++) {
                if(isRemove[i]) continue;
                sb.append(arr[i]);
            }

            answer.add(sb.toString());
            return;
        }

        selected[depth] = true;
        go(depth + 1);
        selected[depth] = false;
        go(depth + 1);
    }

}