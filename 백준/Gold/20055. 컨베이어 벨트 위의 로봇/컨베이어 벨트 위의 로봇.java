import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, K, zeroCnt, time;
    static LinkedList<Belt> conveyorBelt = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 2 * N; i++) {
            conveyorBelt.add(new Belt(Integer.parseInt(st.nextToken())));
        }

        while(zeroCnt < K) {
            time++;
            rotateConveyorBelt();
            rotateRobot();
        }

        System.out.println(time);
        in.close();
    }

    static void rotateConveyorBelt() {
        conveyorBelt.add(0, conveyorBelt.removeLast());
        conveyorBelt.get(N - 1).robot = false;
    }

    static void rotateRobot() {
        for (int i = N - 1; i > 0; i--) {
            if(!conveyorBelt.get(i).robot
                    || conveyorBelt.get(i + 1).robot
                    || conveyorBelt.get(i + 1).durability == 0)
                continue;
            conveyorBelt.get(i).robot = false;
            putRobot(i + 1);
        }
        conveyorBelt.get(N - 1).robot = false;
        // 새로운 로봇 두기
        if(conveyorBelt.get(0).durability > 0) putRobot(0);
    }

    static void putRobot(int idx) {
        conveyorBelt.get(idx).robot = true;
        conveyorBelt.get(idx).durability = Math.max(conveyorBelt.get(idx).durability - 1, 0);
        if(conveyorBelt.get(idx).durability == 0) zeroCnt++;
    }

    static class Belt {
        int durability;
        boolean robot;

        public Belt(int durability) {
            this.durability = durability;
            this.robot = false;
        }

    }

}