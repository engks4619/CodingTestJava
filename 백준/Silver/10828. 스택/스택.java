import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            String operation = st.nextToken();
            Integer num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : null;
            Integer res = Operator.valueOf(operation).execute(num);
            if(res != null) sb.append(res).append("\n");
        }
        if(sb.length() > 0) sb.setLength(sb.length()-1);
        System.out.println(sb);
        in.close();
    }

    enum Operator {
        push("push", stack::push,null),
        pop("pop",null, () -> !stack.isEmpty() ? stack.pop() : -1),
        size("size", null, () -> stack.size()),
        empty("empty", null, () -> stack.isEmpty() ? 1 : 0),
        top("top", null, () -> !stack.isEmpty() ? stack.peek() : -1);

        private String operator;
        private IntConsumer intConsumer;
        private IntSupplier intSupplier;

        Operator(String operator, IntConsumer intConsumer, IntSupplier intSupplier){
            this.operator = operator;
            this.intConsumer = intConsumer;
            this.intSupplier = intSupplier;
        }

        Integer execute(Integer num){
            if(num == null) return this.intSupplier.getAsInt();
            this.intConsumer.accept(num);
            return null;
        }

    }
}