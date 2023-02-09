import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer condition = Integer.parseInt(br.readLine());
        BigInteger originNum = new BigInteger(br.readLine());

        BigInteger[] nums = new BigInteger[condition];

        BigInteger digit = BigDecimal.valueOf(Math.pow(10, condition - 1)).toBigInteger();

        for(int i = 0; i < nums.length; i++) {
            nums[i] = originNum.divide(digit);
            originNum = originNum.subtract( nums[i].multiply(digit));
            digit = digit.divide(BigDecimal.valueOf(10).toBigInteger());
        }

        BigInteger result = new BigInteger("0");

        for(BigInteger e : nums) {
            result = result.add(e);
        }

        System.out.println(result);
    }
}