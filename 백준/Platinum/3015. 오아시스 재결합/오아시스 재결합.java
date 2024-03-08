import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Stack<Node> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(in.readLine());
            Node currNode = new Node(height, 1);
            while (!stack.isEmpty() && stack.peek().height <= currNode.height) {
                Node prevNode = stack.pop();
                cnt += prevNode.cnt;
                if (prevNode.height == currNode.height)
                    currNode.cnt += prevNode.cnt;
            }
            if(!stack.isEmpty()) cnt++;
            stack.push(currNode);
        }
        System.out.println(cnt);
        in.close();
    }

    static class Node {
        int height;
        int cnt;

        public Node(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

}