import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n; 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine()); // nums; 입력받기

        long[] parseNums = new long[n]; // int[]로 변환
        int idx = 0;
        while (st.hasMoreElements()) {
            parseNums[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        Arrays.sort(parseNums); // 오름차순 정렬; 투 포인터를 사용하기 위한 준비

        int result = 0;
        for (int k = 0; k < parseNums.length; k++) {
            long target = parseNums[k];
            int start = 0;
            int end = n - 1;

            while (start < end) {
                if (parseNums[start] + parseNums[end] == target) {
                    if (start != k && end != k) {
                        result++;
                        break;
                    } else if (start == k) {
                        start++;
                    } else if (end == k) {
                        end--;
                    }
                } else if (parseNums[start] + parseNums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(result);
    }
}