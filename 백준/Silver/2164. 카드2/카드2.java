import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader sr =  new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(sr.readLine());

        Integer result = getLastCard(num);
        System.out.println(result);
    }

    public static Integer getLastCard(int num) {
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < num; i++) {
            deque.add(i+1);
        }

        int cnt = 1;
        while(!(deque.size() == 1)) {
            if(cnt % 2 == 1) {
                deque.removeFirst();
            } else {
                deque.addLast(deque.removeFirst());
            }

            cnt ++;
        }

        return deque.remove();
    }
}