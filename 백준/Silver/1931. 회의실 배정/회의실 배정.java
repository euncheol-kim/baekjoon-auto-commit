import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static ArrayList<Meeting> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Input -> 1 Line
        int n = Integer.parseInt(br.readLine());

        // 데이터 적재작업
        for(int i = 0; i < n; i++) {
            int[] reservation = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = reservation[0];
            int end = reservation[1];

            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        // 알고리즘 진행
        /* 같은 수에서, 최소값에 대한 카운터를 남겨야한다. */
        Meeting prev = list.remove(0);
        int cnt = 1;
        while ( !list.isEmpty() ) {
            Meeting cur = list.remove(0);
            // 현재 회의 시간이 이전 회의 시간 안에 있다면
            if (prev.start <= cur.start && prev.end >= cur.end) {
                // 현재 / 이전 회의 시간의 차이가 누가 더 작은지 판별한다.
                int prevSubTime = prev.end - prev.start;
                int curSubTime = cur.end - cur.start;

                // curSubTime이 0이라는 것은 회의가 시작과 동시에 끝남을 의미한다.
                if(curSubTime == 0 && prev.end == cur.end) {
                    cnt ++;
                    prev = cur;

                // 만약, 현재 회의 시간이 더 작으면, 현재 회의를 기준으로 하여금 이후의 회의 시간들과 판별 될 수 있도록 한다.
                } else if(prevSubTime > curSubTime) {
                    prev = cur;
                }
            // 만약, 현재 회의 시간이 이전 회의 시간 안에 존재하지 않는 경우라면
            } else {
                // 현재 회의 시간의 start가 이전 회의 시간 end와 같거나 큰 경우에 대하여 cnt를 높인다.
                if(cur.start >= prev.end) {
                    cnt ++;
                    prev = cur;
                }
            }
        }

        System.out.println(cnt);
    }
}

// meeting의 객체를 정렬하기 위해서 Comparable 상속
class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    private Meeting() {}
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        // 오름차순 
        if(this.start == m.start) {
            return this.end - m.end;
        }
        return this.start - m.start;
    }
}

//prev.start >= cur.start &&