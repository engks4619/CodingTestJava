import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    static int[] queue = new int[10001];
    static int first = 0;
    static int last = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            String operation = st.nextToken();
            if(st.hasMoreTokens()) {
                Operator.valueOf(operation).execute(Integer.parseInt(st.nextToken()));
                continue;
            }
            int res = Operator.valueOf(operation).execute();
            sb.append(res).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    enum Operator {
        push("push", (num) -> queue[last++] = (Integer) num),
        pop("pop", () -> last - first > 0 ? queue[first++]: -1),
        size("size", () -> last - first),
        empty("empty", () -> last - first == 0 ? 1 : 0),
        front("front", () -> last - first > 0 ? queue[first] : -1),
        back("back", () -> last - first > 0 ? queue[last - 1] : -1);

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

        void execute(Integer num){
            this.consumer.accept(num);
        }

        Integer execute(){
            return (Integer) this.supplier.get();
        }

    }

}