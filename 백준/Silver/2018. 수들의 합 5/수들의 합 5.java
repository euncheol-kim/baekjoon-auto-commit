import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer input = Integer.parseInt(br.readLine());

        int[] nums = new int[input + 1];

        // 순차적 숫자의 초기화 진행
        for(int i = nums.length - 1; i > 0; i--) {
            nums[i] = i;
        }

        int condition = nums.length - 1;
        int result = 0;
        while(condition > 0) {
            result += calculator(input, nums, condition);
            condition --;
        }

        System.out.println(result);
    }

    private static int calculator(int input, int[] nums, int condition) {
        // 첫 번째 들어오는 수는 반드시 카운트한다.
        if(nums[condition] == input) {
            return 1;
        } else {
            // input값과 연속된 숫자의 합인지 판별하는 코드
            int sum = 0;
            do {
                sum = sum + nums[condition];
                condition --;
            } while(sum < input && condition >= 1);

            if(sum == input) return 1;
            return 0;
        }
    }

}