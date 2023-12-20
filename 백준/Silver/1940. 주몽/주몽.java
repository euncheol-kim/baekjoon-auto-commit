import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(nums);

        int head = 0;
        int tail = nums.length-1;
        int result = 0;
        while(head != tail) {
            if(nums[head] + nums[tail] == M) {
                result ++;
                tail --;
            } else if(nums[head] + nums[tail] > M) {
                tail --;
            } else {
                head ++;
            }
        }

        System.out.println(result);
    }
}
