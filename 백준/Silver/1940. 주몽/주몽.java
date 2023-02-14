import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        Integer M = Integer.parseInt(br.readLine());
        String[] strUnique = br.readLine().split(" ");

        // set 타입 생성 후, strUnique를 Integer로 변환하여 set 타입에 저장
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(strUnique[i]));
        }

        for(Integer e : set) {
            int temp = M - e;
            if(set.contains(temp)) {
                result ++;
            }
        }

        System.out.println(result / 2);
    }
}