import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        int result = 1;
        int sum = 0;
        int start = 0;
        int end = 0;

        int[] nums = new int[n + 1];

        // 순차적 숫자의 초기화 진행
        for (int i = 1; i < nums.length; i++) {
            nums[i] = i;
        }

        // query
        while(n != end) {
            if(sum == n) {
                result ++;
                end ++;
                sum += nums[end];
            } else if(sum < n){
                end ++;
                sum += nums[end];
            } else  {
                sum = sum - nums[start];
                start ++;
            }
        }

        System.out.println(result);
    }

}