import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()) + 1;
        int m = Integer.parseInt(stk.nextToken());
        int r = 0;

        for(int i = 1; i < n; i++) {
            r = (r + m) % i;
        }

        // result
        System.out.println(r + 1);
    }
}