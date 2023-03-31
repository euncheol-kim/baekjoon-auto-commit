import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Input -> 1 Line
        int n = Integer.parseInt(br.readLine());

        // Input -> 정수값 입력 받기 {양수, 음수} 나누어 저장
        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(br.readLine());

            if( num > 0 ) {
                positive.add(num);
            } else if ( num <= 0 ) {
                negative.add(num);
            }
        }

        // 양수 : 내림차순 정렬 {1000, 999, ....}
        Collections.sort(positive, Collections.reverseOrder());
        // 음수 : 오름차순 정렬 {-3, -2, -1, ....}
        Collections.sort(negative);

        /* 문제 조건에 부합하는 로직 진행*/
        int positiveSum = 0;
        int negativeSum = 0;

        if( !positive.isEmpty() ) {
            positiveSum = partitionCalculator(positive);
        }

        if( !negative.isEmpty() ) {
            negativeSum = partitionCalculator(negative);
        }

        System.out.println(positiveSum + negativeSum);
    }

    public static int partitionCalculator(ArrayList<Integer> list) {
        if(list.size() == 1) {
            return list.remove(0);
        }

        if( list.get(list.size() - 1) == 0 ) {
            int idx = (list.size() - 1) - ( (list.size() - 1) / 2);
            if(idx > 1) {
                list.remove(idx + 1);
            } else {
                list.remove(0);
            }
        }

        int result = 0;

        while(list.size() > 1) {
            int first = list.remove(0);
            int second = list.remove(0);

            if( first * second > first + second ) {
                result = result + (first * second);
            } else {
                result = result + first + second;
            }
        }

        if(list.size() == 1) {
            result += list.remove(0);
        }

        return result;
    }
}