import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        double v = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(in.readLine());
        double xs = Double.parseDouble(st.nextToken());
        double ys = Double.parseDouble(st.nextToken());
        double maxDistance = v * m * 60;
        st = new StringTokenizer(in.readLine());
        double xt = Double.parseDouble(st.nextToken());
        double yt = Double.parseDouble(st.nextToken());
        List<Bunker> bunkerList = new ArrayList<>();
        String input;
        while((input = in.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            double r = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            bunkerList.add(new Bunker(r, c));
        }
        boolean isPossible = false;
        int cnt = 0;
        Queue<Node> queue = new ArrayDeque<>();
        Set<Bunker> visited = new HashSet<>();
        queue.offer(new Node(xs, ys, 0));
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(getDistance(xt, yt, curr.r, curr.c) < maxDistance) {
                cnt = curr.cnt;
                isPossible = true;
                break;
            }
            for (Bunker bunker : bunkerList) {
                if(visited.contains(bunker)
                        || getDistance(curr.r, curr.c , bunker.r, bunker.c) > maxDistance) continue;
                visited.add(bunker);
                queue.offer(new Node(bunker.r, bunker.c, curr.cnt + 1));
            }
        }

        String answer = !isPossible ? "No." : "Yes, visiting " + cnt + " other holes.";
        bw.write(answer);
        bw.flush();
        bw.close();
        in.close();
    }

    static double getDistance(double x, double y, double r, double c) {
         return Math.sqrt(Math.pow(x - r, 2) + Math.pow(y - c, 2));
    }

    static class Bunker {
        double r, c;

        public Bunker(double r, double c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node extends Bunker {
        int cnt;

        public Node(double r, double c, int cnt) {
            super(r, c);
            this.cnt = cnt;
        }

    }

}