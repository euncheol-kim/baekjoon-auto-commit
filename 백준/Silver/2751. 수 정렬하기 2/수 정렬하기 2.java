import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *   수 정렬하기2
 *       MergeSort
 * */

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n; 1 <= N <= 1,000,000 [Input -> 1Line]
        int n = Integer.parseInt(br.readLine());
        // nums; 입력 숫자를 저장할 변수
        int[] nums = new int[n];

        // 숫자 입력 받기
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // mergeSort진행 (Divide - Conquer)
        mergeSort(nums);
        print(nums);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start,mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }

    public static void merge(int[] arr, int start, int end, int mid) {

        int[] temp;
        temp = new int[end - start + 1];

        for(int i = 0; i < temp.length; i++) {
            temp[i] = arr[i + start];
        }

        int leftIdx = start;
        int rightIdx = mid + 1;
        int idx = start;

        // start <= mid && mid + 1 <= end
        while(leftIdx <= mid && rightIdx <= end) {

            if(temp[leftIdx - start] <= temp[rightIdx - start]) {
                arr[idx] = temp[leftIdx - start];

                leftIdx ++;
            } else {
                arr[idx] = temp[rightIdx - start];

                rightIdx ++;
            }
            
            idx ++;
        }
        
        // 좌측 파티션이 남은 경우에 대한 값을 넣어주는 코드
        for(int i = 0; i <= mid - leftIdx; i++) {
            arr[idx + i] = temp[i + leftIdx - start];
        }
        
    }

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int e : arr) {
            sb.append(e).append('\n');
        }
        System.out.print(sb);
    }
}
