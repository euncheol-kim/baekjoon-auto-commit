import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int subjects = Integer.parseInt(br.readLine());
        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int great = Arrays.stream(scores).max().getAsInt();

        double result = 0;
        for (int i = 0; i < scores.length; i++) {
            double convertScore = (double) scores[i] / great * 100;
            result += convertScore;
        }

        System.out.println(result / subjects);
    }
}