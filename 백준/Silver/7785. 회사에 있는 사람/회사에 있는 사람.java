import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            String act = st.nextToken();
            switch (ActType.valueOf(act)) {
                case enter -> set.add(name);
                case leave -> set.remove(name);
            }
        }
        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for (String name : list) bw.write(name + "\n");
        bw.flush();
        bw.close();
        in.close();
    }

    public enum ActType {
        enter,
        leave;
    }

}