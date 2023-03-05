import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // [Input -> 1Line]
        int n = Integer.parseInt(br.readLine());

        /* 변수 설정 */
        int[] nums = new int[n];

        // [Input -> 2Line ~ (n + 1)Line]
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for (int e : nums) {
            System.out.println(e);
        }
    }
}