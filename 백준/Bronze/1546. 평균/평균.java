import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 첫 라인에 들어가는 숫자 :: 쓰지 않음
        String[] strNums = br.readLine().split(" ");

        // doulb[] 배열 저장
        double[] originNums = Arrays.stream(strNums)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // stream descending sorted를 위한 stream.boxed
        Double[] descNums = Arrays.stream(originNums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Double[]::new);

        double topScore = descNums[0];
        for(int i = 0; i < descNums.length; i++) {
            // 점수 / 최고점 * 100
            originNums[i] = (descNums[i] / topScore) * 100;
        }

        double result = Arrays.stream(originNums).average().getAsDouble();
        System.out.println(result);
    }
}