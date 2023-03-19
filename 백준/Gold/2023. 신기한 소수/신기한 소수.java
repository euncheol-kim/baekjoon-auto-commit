import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n; [ Input -> 1 Line ]
        int n = Integer.parseInt(br.readLine());

        for(int i = 2; i < 10; i++) {
            if(isPrime(i)) {
                operatedDFS(i, n);
            }
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        //TODO 소수판별
        for(int i =  2;  i <= Math.sqrt(num); i++) {
            if( num % i == 0 ) return false;
        }

        return true;
    }

    public static void operatedDFS(int num, int digit) {
        // 기저의 설정
        if(digit == 1) {
            if(isPrime(num)) {
                sb.append(num).append("\n");
            }
            
            return;
        }

        // DFS 연산 진행;
        for(int i = 1; i < 10; i = i + 2) {
            if(isPrime(num * 10 + i)) {
                operatedDFS(num * 10 + i, digit - 1);
            }
        }

    }
}
