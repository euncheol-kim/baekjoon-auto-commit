import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] partition = new int[nums.length];
        partition[0] = nums[0];
        for(int i = 1; i < partition.length; i++) {
            partition[i] = partition[i-1] + nums[i];
        }

        while (0 < NM[1]) {
            int[] condition = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            int operation;
            if(condition[0] == 1) {
                operation = partition[condition[1] - 1];
            } else {
                operation = partition[condition[1] - 1] - partition[condition[0] - 2];
            }
            sb.append(operation).append("\n");

            NM[1] --;
        }

        System.out.println(sb);
    }
}