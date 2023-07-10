import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = NM[0];
        int m = NM[1];

        long[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long[] prefixSumModM = new long[nums.length + 1];
        long[] remainders = new long[m];
        for(int i = 1; i < prefixSumModM.length; i++) {
            prefixSumModM[i] = (prefixSumModM[i - 1] + nums[i - 1]) % m;

            if (prefixSumModM[i] == 0) result ++;
            remainders[(int)prefixSumModM[i]] ++;
        }

        for(int i = 0; i < remainders.length; i++) {
            if(remainders[i] > 1)  {
                result = result + ( (remainders[i] * (remainders[i] - 1) ) / 2 );
            }
        }

        System.out.print(result);

    }
}