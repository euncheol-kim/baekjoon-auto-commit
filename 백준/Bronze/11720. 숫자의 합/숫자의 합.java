import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numCount = br.readLine();
        String nums = br.readLine();

        long result = 0;
        for(int i = 0; i < Integer.parseInt(numCount); i++) {
            int num = Character.getNumericValue(nums.charAt(i));
            result += num;
        }

        System.out.print(result);
    }
}