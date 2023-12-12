import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class Main {

    static LinkedList<Character> list = new LinkedList<>();
    static ListIterator<Character> listIterator;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(char c : in.readLine().toCharArray()){
            list.add(c);
        }
        listIterator = list.listIterator();
        while(listIterator.hasNext()){
            listIterator.next();
        }

        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String operation = st.nextToken();
            Character c = st.hasMoreTokens() ? st.nextToken().charAt(0) : null;
            Operator.valueOf(operation).execute(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
        in.close();
    }

    enum Operator{
        L('L', () -> {
            if(!listIterator.hasPrevious()) return;
            listIterator.previous();
        }),
        D('D', () -> {
            if(!listIterator.hasNext()) return;
            listIterator.next();
        }),
        B('B',() -> {
            if(!listIterator.hasPrevious()) return;
            listIterator.previous();
            listIterator.remove();
        }),
        P('P', (c) -> listIterator.add((Character) c));

        Character operation;
        Consumer consumer;
        Runnable runnable;

        Operator(Character operation, Consumer consumer){
            this.operation = operation;
            this.consumer = consumer;
        }
        Operator(Character operation, Runnable runnable){
            this.operation = operation;
            this.runnable = runnable;
        }

        void execute(Character c){
            if(c == null) {
                this.runnable.run();
                return;
            }
            this.consumer.accept(c);
        }
    }

}