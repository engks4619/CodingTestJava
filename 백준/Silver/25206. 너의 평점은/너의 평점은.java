import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int gradeCnt = 20;
        StringTokenizer st;
        double avgSum = 0;
        double scoreSum = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            double avgScore = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            double score = 0;
            switch (grade.charAt(0)) {
                case 'P' :
                    continue;
                case 'F' :
                    break;
                case 'A' :
                    score += grade.charAt(1) == '+' ? 4.5 : 4.0;
                    break;
                case 'B' :
                    score += grade.charAt(1) == '+' ? 3.5 : 3.0;
                    break;
                case 'C' :
                    score += grade.charAt(1) == '+' ? 2.5 : 2.0;
                    break;
                case 'D' :
                    score += grade.charAt(1) == '+' ? 1.5 : 1.0;
                    break;
            }
            avgSum += avgScore;
            scoreSum += score * avgScore;
        }
        System.out.printf("%f", scoreSum / avgSum);
        in.close();
    }
}