import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> data;

        // Input -> 1 Line
        int n = Integer.parseInt(br.readLine());
        data = new ArrayList<>();

        // data입력 받기 (Input -> 2 Line)
        for(int i = 0; i < n; i++) {
            int e = Integer.parseInt(br.readLine());
            data.add(e);
        }

        printMinimum(data);
    }
    
    public static void printMinimum(ArrayList<Integer> data) {
        // data가 1개인 경우의 기저 설정 및 출력
        if(data.size() == 1) {
            System.out.println(0);
            return;
        }

        Collections.sort(data);
        ArrayList<Integer> partitionSum = new ArrayList<>(); // 구간의 합을 저장한다. 구간이란 (10 + 20), (30+40) 같은 각각의 경우를 말함

        /* partitionSum의 값을 저장하고 data의 재배치가 이루어지는 로직 */
        while( !data.isEmpty() ) {
            int sum = 0;

            if(data.size() > 1) {
                for (int i = 0; i < 2; i++) {
                    sum = sum + data.remove(0);
                }

                // 원본 data를 다시 오름차순으로 정렬 진행
                addElementInAscendingOrder(data, sum);

                //partionSum에 sum을 저장
                partitionSum.add(sum);
            } else {
                sum = partitionSum.get(partitionSum.size() - 1) + data.get(0);
                partitionSum.add(sum);
            }
        }

        /* partitionSum을 출력하는 로직 */
        int result = 0;
        for(int e : partitionSum) {
            result += e;
        }
        System.out.println(result);



    }

    public static void addElementInAscendingOrder(ArrayList<Integer> data, int element) {
        // data값이 변화하면서 빈 경우에 대한 기저설정
        if( data.isEmpty() ) return;
        addElementInAscendingOrder(data, element, 0, data.size() - 1);
    }

    public static void addElementInAscendingOrder(ArrayList<Integer> data, int element, int start, int end) {
        int midIdx = (start + end) / 2;

        if(start > end) {
            data.add(midIdx + 1, element);
            return;
        }

        if (start == end) {
            if (data.get(midIdx) <= element) data.add(midIdx + 1, element);
            else if(data.get(midIdx) > element) data.add(midIdx, element);
            return;
        }

        if(data.get(midIdx) < element) addElementInAscendingOrder(data, element, midIdx + 1, end);
        else if(data.get(midIdx) > element) addElementInAscendingOrder(data, element, start, midIdx - 1);
        else if(data.get(midIdx) == element) data.add(midIdx, element);
    }
}