import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // [N : Matrix 크기] [M : 몇 번 입력 받을건지]
        String[] n_and_m =  br.readLine().split(" ");

        int n = Integer.parseInt(n_and_m[0]);
        int m = Integer.parseInt(n_and_m[1]);

        // Created 2-dimension-matrix, size n+1
        int[][] matrix = new int[n+1][n+1];

        // Created 2-dimension-matrix prefixNums
        int[][] prefixMatrixSum = new int[n+1][n+1];

        // result
        int[] result = new int[m];
        
        // Matrix에 number 저장 -> 여기까지 이상없음
        savedMatrixNumberAndPrefixSum(matrix, prefixMatrixSum);
        // 범위 받은 후, 범위에 따른 처리진행하는 함수
        setScopeCalculator(prefixMatrixSum, result);

        print(result);

    }

    private static void print(int[] result) {
        for(int e : result) {
            System.out.println(e);
        }
    }

    private static void setScopeCalculator(int[][] prefixMatrixSum, int[] result) throws Exception {
        for(int i = 1; i <= result.length; i++) {
            String[] condition = br.readLine().split(" ");
            result[i-1] = scopeCalculator(prefixMatrixSum, condition);
        }
    }

    private static int scopeCalculator(int[][] prefixMatrixSum, String[] condition) {
        int sum = 0;

        int[] tempCondition = Arrays.stream(condition)
                .mapToInt(Integer::parseInt)
                .toArray();

        int x1 = tempCondition[0];
        int y1 = tempCondition[1];
        int x2 = tempCondition[2];
        int y2 = tempCondition[3];

        if(x1 == x2 && y1 == y2) return prefixMatrixSum[x1][y1] - prefixMatrixSum[x1][y1 - 1];

        int scope = x2 - x1;
        for(int i = 0; i <= scope; i++) {
            sum = sum + (prefixMatrixSum[i + x1][y2] - prefixMatrixSum[i + x1][y1 - 1]);
        }

        return sum;
    }

    private static void savedMatrixNumberAndPrefixSum(int[][] matrix, int[][] prefixMatrixSum) throws Exception {
        for(int i = 1; i < matrix.length; i++) {
            // 입력받기
            String[] rowNums = br.readLine().split(" ");
            for(int j = 1; j < matrix[i].length; j++) {
                // 변환하여 loop에 해당하는 matrix값을 저장
                matrix[i][j] = Integer.parseInt(rowNums[j - 1]);
                prefixMatrixSum[i][j] = prefixMatrixSum[i][j-1] + matrix[i][j];
            }
        }
    }
}