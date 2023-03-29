import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input -> 1 Line
        int[] nk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nk[0]; // 동전 갯수
        int k = nk[1]; // 금액

        List<Integer> coins = new ArrayList<>(); // 코인 저장소 (오름차순)

        // Input -> 2 Line ~
        for(int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
        }

        // coinKey; coins map의 key를 내림차순으로 정렬하는 과정
        int finalK = k;
        coins = coins.stream()
                    .filter(e -> e <= finalK)
                    .collect(Collectors.toList());

        Collections.reverse(coins);

        // 문제풀이 진행
        int result = 0;
        for(int coin : coins) {

            if( k > 0) {
                result = result + (k / coin);
                k = k % coin;
            }

        }

        System.out.println(result);
    }
}