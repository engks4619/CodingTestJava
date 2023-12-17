import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Stack<Character> opStack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(char c : in.readLine().toCharArray()){
            // 영대문자 검사
            if(Pattern.matches("^[A-Z]", c + "")) {
                sb.append(c);
                continue;
            }
            Operation.opMap.get(c).execute(c);
        }
        while (!opStack.isEmpty()){
            sb.append(opStack.pop());
        }
        System.out.println(sb);
        in.close();
    }


    enum Operation {
        BRACKET_LEFT('(', (c) -> opStack.push((char) c)),
        BRACKET_RIGHT(')', (c) -> {
                while(!opStack.isEmpty()) {
                    char op = opStack.pop();
                    if(op == '(') break;
                    sb.append(op);
                }
        }),
        PLUS('+', (c) -> normalOpFunc((char) c)),
        MINUS('-', (c) -> normalOpFunc((char) c)),
        MULTIPLY('*', (c) -> normalOpFunc((char) c)),
        DIVIDE('/', (c) -> normalOpFunc((char) c));

        Character operator;
        Consumer consumer;

        Operation(Character operator, Consumer consumer) {
            this.operator = operator;
            this.consumer = consumer;
        }

        void execute(char c){
            this.consumer.accept(c);
        }

        static void normalOpFunc(char c){
            outer: while(!opStack.isEmpty()){
                char op = opStack.peek();
                switch (c){
                    case '+':
                    case '-':
                        if(op == '+' || op == '-' || op == '*' || op == '/') sb.append(opStack.pop());
                        else break outer;
                        break;
                    case '*':
                    case '/':
                        if(op == '*' || op == '/') sb.append(opStack.pop());
                        else break outer;
                        break;
                    default:
                        break outer;
                }
            }
            opStack.push(c);
        }

        static Map<Character, Operation> opMap = new HashMap<>();

        static {
            for(Operation value: Operation.values()){
                opMap.put(value.operator, value);
            }
        }
    }

}