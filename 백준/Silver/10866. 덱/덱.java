import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    static int[] deque = new int[10000];
    static int front = 0;
    static int back = 0;
    static int size = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            String operation = st.nextToken();
            if(st.hasMoreTokens()){
                Operator.valueOf(operation).execute(Integer.parseInt(st.nextToken()));
                continue;
            }
            sb.append(Operator.valueOf(operation).execute()).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    enum Operator {
        push_front("push_front", pushFrontFunc),
        push_back("push_back", pushBackFunc),
        pop_front("pop_front", popFrontFunc),
        pop_back("pop_back", popBackFunc),
        size("size", sizeFunc),
        empty("empty", emptyFunc),
        front("front", frontFunc),
        back("back", backFunc);

        String operation;
        Consumer consumer;
        Supplier supplier;

        Operator(String operation, Consumer consumer) {
            this.operation = operation;
            this.consumer = consumer;
        }

        Operator(String operation, Supplier supplier) {
            this.operation = operation;
            this.supplier = supplier;
        }

        void execute(int num){
            this.consumer.accept(num);
        }

        int execute(){
            return (int) this.supplier.get();
        }
    }
    static Consumer pushFrontFunc = (num) -> {
        deque[front] = (int) num;
        front = (front - 1 + 10000) % 10000;
        size++;
    };
    static Consumer pushBackFunc = (num) -> {
        back = (back + 1) % 10000;
        deque[back] = (int) num;
        size++;
    };
    static Supplier popFrontFunc = () -> {
        if(size == 0) return -1;
        int num = deque[(front + 1) % 10000];
        front = (front + 1) % 10000;
        size--;
        return num;
    };
    static Supplier popBackFunc = () -> {
        if(size == 0) return -1;
        int num = deque[back];
        back = (back - 1 + 10000) % 10000;
        size--;
        return num;
    };
    static Supplier sizeFunc = () -> size;
    static Supplier emptyFunc = () -> size == 0 ? 1 : 0;
    static Supplier frontFunc = () -> {
        if(size == 0) return -1;
        return deque[(front + 1) % 10000];
    };
    static Supplier backFunc = () -> {
        if(size == 0) return -1;
        return deque[back];
    };


}