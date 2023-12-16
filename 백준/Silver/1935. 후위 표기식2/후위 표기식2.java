import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        for(Character c : str.toCharArray()){
            //영어 대문자면 피연산자이므로 스택에 push 후 넘기기
            if(Pattern.matches("^[A-Z]$", c + "")){
                stack.push((double) arr[c - 'A']);
                continue;
            }
            double right = stack.pop();
            double left = stack.pop();
            stack.push(Operator.operatorMap.get(c).execute(left, right));
        }
        System.out.printf("%.2f", stack.pop());
        in.close();
    }

    enum Operator {
        PLUS('+', (a, b) -> a + b),
        MINUS('-', (a, b) -> a - b),
        MULTIPLY('*', (a, b) -> a * b),
        DIVIDE('/', (a, b) -> a / b);

        Character operation;
        BiFunction<Double , Double , Double> expression;

        Operator(Character operation, BiFunction<Double, Double, Double> expression) {
            this.operation = operation;
            this.expression = expression;
        }

        Double execute(double a, double b){
            return this.expression.apply(a, b);
        }

        static Map<Character, Operator> operatorMap = new HashMap<>();
        static {
            for (Operator value : Operator.values()){
                operatorMap.put(value.operation, value);
            }
        }
    }
}