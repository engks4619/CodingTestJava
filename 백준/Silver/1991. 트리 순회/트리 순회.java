import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Character, Node> treeMap;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        treeMap = new HashMap<>();
        int N = Integer.parseInt(in.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            char key = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            treeMap.put(key, new Node(key, left, right));
        }
        prevSearch('A');
        System.out.println();
        midSearch('A');
        System.out.println();
        lastSearch('A');
        in.close();
    }
    public static void prevSearch(char root) {
        System.out.print(root);
        Node curr = treeMap.get(root);
        if(curr.left != '.'){
            prevSearch(curr.left);
        }
        if(curr.right != '.'){
            prevSearch(curr.right);
        }
    }

    public static void midSearch(char root) {
        Node curr = treeMap.get(root);
        if(curr.left != '.'){
            midSearch(curr.left);
        }
        System.out.print(root);
        if(curr.right != '.'){
            midSearch(curr.right);
        }
    }

    public static void lastSearch(char root) {
        Node curr = treeMap.get(root);
        if(curr.left != '.'){
            lastSearch(curr.left);
        }
        if(curr.right != '.'){
            lastSearch(curr.right);
        }
        System.out.print(root);
    }

}



class Node {
    char root;
    char left;
    char right;

    public Node(char root, char left, char right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
}