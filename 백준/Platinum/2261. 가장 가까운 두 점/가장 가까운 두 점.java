import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<Point> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        list.sort(Comparator.comparingInt(o -> o.x));
        int minDist = getDist(list.get(0), list.get(1));
        TreeSet<Point> set = new TreeSet<>((o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
        set.add(list.get(0));
        set.add(list.get(1));
        int leftIdx = 0;
        for (int i = 2; i < N; i++) {
            Point curr = list.get(i);
            while(leftIdx < i) {
                Point target = list.get(leftIdx);
                int xDist = curr.x - target.x;
                if(xDist * xDist > minDist) {
                    set.remove(target);
                    leftIdx++;
                }
                else break;
            }

            int sqrtMinDist = (int) Math.sqrt(minDist) + 1;
            TreeSet<Point> tmpSet = (TreeSet<Point>) set.subSet(new Point(-100000, curr.y - sqrtMinDist), new Point(100000, curr.y + sqrtMinDist));
            for(Point point : tmpSet) {
                minDist = Math.min(minDist, getDist(point, curr));
            }

            set.add(curr);
        }

        System.out.println(minDist);
        in.close();
    }

    static int getDist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}