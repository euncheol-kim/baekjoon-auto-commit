import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" "); // 첫 라인
        String[] inputNums = br.readLine().split(" "); // 둘째 라인

        // 둘째 라인 int[] 변환
        int[] convertNums = convertNums(inputNums);

        // 반복에 대한 값만 가져옴
        int repeat = Integer.parseInt(firstLine[1]);

        // prefixSum 배열 정의
        int[] prefixSum = new int[convertNums.length + 1];

        // 결과를 담을 int 배열
        int[] result = new int[repeat];


        // setPrefixSum
        setPrefixSum(convertNums, prefixSum);

        // 입력값을 repeat만큼 받고, 반환할 result에 구간합을 저장
        for(int i = 0; i < repeat; i ++) {
            String[] temp = br.readLine().split(" ");

            int[] condition = Arrays.stream(temp)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 구간합 저장
            result[i] = getSection(convertNums, condition, prefixSum);
        }

        print(result);

    }

    private static void setPrefixSum(int[] convertNums, int[] prefixSum) {
        for(int i = 1; i < convertNums.length + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + convertNums[i - 1];
        }
    }

    public static int getSection(int[] convertNums, int[] condition, int[] prefixSum) {
        if(condition[0] == condition[1]) return convertNums[condition[0] - 1];
        return prefixSum[condition[1]] - prefixSum[condition[0] - 1];
    }

    public static void print(int[] result) {
        for(int e : result) {
            System.out.println(e);
        }
    }

    public static int[] convertNums(String[] inputNums) {
        return Arrays.stream(inputNums)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}