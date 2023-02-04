import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] condition = br.readLine().split( " "); // 첫 줄 입력받기
        String[] strNums = br.readLine().split(" "); // 두 번째줄 입력 받기

        int[] nums = Arrays.stream(strNums) // int 배열로 변환
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int e : nums) {
            if(Integer.parseInt(condition[1]) > e) {
                System.out.printf(e + " ");
            }
        }
    }
}