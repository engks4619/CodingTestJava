import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String T = in.readLine();
        String P = in.readLine();
        Queue<Integer> queue = kmp(T, P);
        StringBuilder sb = new StringBuilder();
        sb.append(queue.size()).append("\n");
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb);
        in.close();
    }

    static int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = ++len;
                i++;
            }
            else if(len == 0) i++;
            else len = lps[len - 1];
        }

        return lps;
    }

    static Queue<Integer> kmp(String text, String pattern) {
        Queue<Integer> queue = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int[] lps = getLPS(pattern);

        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if(j == pattern.length()) {
                    queue.offer(i - j + 1);
                    j = lps[j - 1];
                }
            }
            else if(j == 0) i++;
            else j = lps[j - 1];
        }
        return queue;
    }

}