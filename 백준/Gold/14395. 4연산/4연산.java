import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static String answer;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        if(s == t) answer = "0";
        else bfs(s, t);
        bw.write(answer != null ? answer : "-1");
        bw.flush();
        bw.close();
        in.close();
    }

    static void bfs(long s, int t) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Long> set = new HashSet<>();
        queue.offer(new Node(s, new StringBuilder()));
        set.add(s);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.s == t){
                answer = curr.sb.toString();
                return;
            }
            for(String op : new String[] {"*", "+", "-", "/"}) {
                StringBuilder nextSb = new StringBuilder(curr.sb);
                if(op.equals("/") && curr.s == 0) continue;
                nextSb.append(op);
                long nextS = getNextS(curr.s, op.charAt(0));
                if(set.contains(nextS)) continue;
                set.add(nextS);
                queue.offer(new Node(nextS, nextSb));
            }
        }
    }

    static long getNextS(long s, char op) {
        switch (op) {
            case '*':
                return s * s;
            case '+':
                return s + s;
            case '-':
                return 0;
            case '/':
                return 1;
        }
        return -1;
    }

    static class Node {
        long s;
        StringBuilder sb;

        public Node(long s, StringBuilder sb) {
            this.s = s;
            this.sb = sb;
        }
    }
}