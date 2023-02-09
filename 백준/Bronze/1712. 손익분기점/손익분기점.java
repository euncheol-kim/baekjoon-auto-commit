import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int[] nums = Arrays.stream(firstLine)
                .mapToInt(v -> Integer.parseInt(v))
                .toArray();

        System.out.println(result(nums));
    }

    public static int result(int[] nums) {
        if(nums[1] >= nums[2]) {
            return -1;
        } else {
            return (nums[0] / (nums[2] - nums[1])) + 1;
        }
    }
}