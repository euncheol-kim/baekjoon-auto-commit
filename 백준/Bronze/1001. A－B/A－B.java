import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Integer[] result = new Integer[str.length];
        
        for(int i = 0; i < result.length; i++) {
            String temp = str[i];
            result[i] = Integer.parseInt(temp);
        }
        
        System.out.println(result[0] - result[1]);
    }
}
