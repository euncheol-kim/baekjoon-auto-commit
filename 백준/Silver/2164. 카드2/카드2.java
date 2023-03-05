import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        // 1 <= n <= 500,000 [Input 1Line]
        int n = Integer.parseInt(br.readLine());

        /* 변수 설정 */
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
    }
}