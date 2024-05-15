import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static Node root;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(in.readLine()));
        String input;
        while((input = in.readLine()) != null && !input.equals("")) {
            root.makeChild(new Node(Integer.parseInt(input)));
        }
        postOrder(root);
        in.close();
    }

    static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.println(node.val);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public void makeChild(Node node) {
            if(val >= node.val) {
                if(this.left == null) this.left = node;
                else this.left.makeChild(node);
            } else {
                if(this.right == null) this.right = node;
                else this.right.makeChild(node);
            }
        }
    }

}