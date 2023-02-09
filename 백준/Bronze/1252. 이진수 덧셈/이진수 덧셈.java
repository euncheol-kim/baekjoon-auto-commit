import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        BigInteger n = new BigInteger(firstLine[0], 2);
        BigInteger m = new BigInteger(firstLine[1], 2);
        BigInteger result = n.add(m);

        System.out.println(result.toString(2));
    }
}

// 주어진 숫자들 -> 10진 변환 -> 합산 -> 2진 변환