import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 절대값이 가장 작아야함

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        while (N-- > 0) {
            int temp = Integer.parseInt(br.readLine());

            // 만약 temp가 0이 아니라면
            if(temp != 0) {
                if(temp > 0) {
                    positiveQueue.add(temp);
                } else {
                    negativeQueue.add(temp);
                }
            // 만약 temp가 0이라면
            } else if(temp == 0) {
                if(!positiveQueue.isEmpty() && !negativeQueue.isEmpty()) {
                    if( Math.abs(positiveQueue.peek()) >= Math.abs(negativeQueue.peek())) {
                        result.add(negativeQueue.remove());
                    } else {
                        result.add(positiveQueue.remove());
                    }
                } else if(!positiveQueue.isEmpty() && negativeQueue.isEmpty()) {
                    result.add(positiveQueue.remove());
                } else if(positiveQueue.isEmpty() && !negativeQueue.isEmpty()) {
                    result.add(negativeQueue.remove());
                } else {
                    result.add(0);
                }
            }
        }

        for(int e : result) {
            System.out.println(e);
        }
    }
}
