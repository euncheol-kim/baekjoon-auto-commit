import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 / 실버 4 / 수 찾기
 * */
public class Main{
    static int N, M;
    static int[] A;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for(int i = 0; i < M; i++){
            if(binarySearch(0, N-1, arr[i])) sb.append(1 + "\n");
            else sb.append(0 + "\n");
        }

        System.out.print(sb.toString());
    }

    private static boolean binarySearch(int start, int end, int val) {
        int mid = (start + end) / 2;

        if(start <= end) {
            if (val < A[mid]) return binarySearch(start, mid - 1, val);
            else if (val > A[mid]) return binarySearch(mid + 1, end, val);
            else return true;
        }
        return false;
    }
}