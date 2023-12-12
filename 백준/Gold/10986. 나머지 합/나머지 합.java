
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] prefixSums = new long[nums.length + 1];
        long[] prefixSumsR = new long[M];
        for(int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = nums[i-1] + prefixSums[i-1];
            long r = prefixSums[i] % M;
            prefixSumsR[(int)r] += 1;
        }

        long result = 0;
        for(int i = 0; i < prefixSumsR.length; i++) {
            result = result + ( (prefixSumsR[i] * (prefixSumsR[i] - 1) ) / 2 );
        }

        System.out.println(result + prefixSumsR[0]);
    }
}
