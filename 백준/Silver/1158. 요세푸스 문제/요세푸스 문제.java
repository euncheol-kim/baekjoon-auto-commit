import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int[] nums = Arrays.stream(firstLine)
                .mapToInt(v -> Integer.parseInt(v))
                .toArray();

        josephus(nums[0], nums[1]);

        if(sb.toString().charAt(sb.toString().length() - 1) == ' ') {
            sb.replace(sb.toString().length()-2, sb.toString().length(), "");
        }

        System.out.println("<" + sb.toString() + ">");
    }

    private static void josephus(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        int cnt = 1;
        while(!queue.isEmpty()) {
            if(cnt == k) {
                sb.append(queue.remove());
                sb.append(", ");
                cnt = 1;
            } else {
                queue.addLast(queue.removeFirst());
                cnt ++;
            }
        }
    }
}