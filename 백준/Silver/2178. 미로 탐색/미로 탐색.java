import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int m;

    // operationBFS; BFS연산값 저장
    public static int[][] operationMatrix;

    // 배열 기준 -> (상, 하, 좌, 우)
    public static int[] dx = {0, 0 , -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input 1Line
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        // matrix && visited && operationBFS 생성
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 사용자 데이터 값 입력 받기 및 matrix 값 저장 [ Input -> 2Line ~ last Line]
        for(int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int j = 0; j < m; j++) {
                matrix[i][j] = line[j];
            }
        }

        operatedBFS(matrix, visited);
        System.out.println(operationMatrix[n - 1][m - 1]);
    }

    public static void operatedBFS(int[][] matrix, boolean[][] visited) {
        operationMatrix = new int[n][m];

        // operationMatrix; 연산에 사용할 2차원 int 배열 선언
        for(int i = 0; i < n; i++) {
            System.arraycopy(matrix[i],0, operationMatrix[i], 0, operationMatrix[i].length - 1);
        }

        operatedBFS(matrix, visited, operationMatrix);
    }

    public static void operatedBFS(int[][] matrix,
                                  boolean[][] visited,
                                  int[][] operationMatrix) {

        // queue; 연산에 이용할 queue
        Queue<int[]> queue = new LinkedList<>();
        // 시작위치 삽입
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while( !queue.isEmpty() ) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i ++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                // matrix 범위를 넘어가지 않는 경우
                if( x >= 0 && y >= 0 && x < n && y < m ) {

                    // 0이 아닌 경우, 방문하지 않은 경우
                    if( matrix[x][y] != 0 && !visited[x][y] ) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});

                        operationMatrix[x][y] = operationMatrix[cur[0]][cur[1]] + 1 ;
                    }

                }

            }
        }
    }
}