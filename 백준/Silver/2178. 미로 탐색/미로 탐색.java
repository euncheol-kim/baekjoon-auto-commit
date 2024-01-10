
import java.util.*;
import java.io.*;

// 더러운코드
// 더러운코드
// 더러운코드
// 더러운코드
// 더러운코드
// 더러운코드



public class Main {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return this.x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return this.y;
        }
    }

    public static int getMinimumDistance(int[][] matrix, boolean[][] visited, Queue<XY> queue,
                                         int N, int M, int depth) {
        visited[N - 1][M - 1] = true;
        queue.add(new XY(N - 1, M - 1));

        while (!queue.isEmpty()) {
            XY xy = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nX = xy.getX() + dx[i];
                int nY = xy.getY() + dy[i];

                // nx와 ny가 matrix범위 넘으면 continue
                if (nX < 0 || N <= nX || nY < 0 || M <= nY) {
                    continue;
                }

                // 방문한 노드라면 또는 0인값이라면
                if (visited[nX][nY] || matrix[nX][nY] == 0) {
                    continue;
                }

                visited[nX][nY] = true;
                matrix[nX][nY] = matrix[nX][nY] + matrix[nX - dx[i]][nY - dy[i]];
                depth = depth + 1;
                queue.add(new XY(nX, nY));

                if (visited[0][0]) return matrix[0][0];
            }
        }

        return matrix[0][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = NM[0];
        int M = NM[1];

        int[][] matrix = new int [N][M];
        boolean[][] visited = new boolean [N][M];
        for(int i=0; i < matrix.length; i++) {
            int[] temp = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = temp;
        }

        Queue<XY> queue = new LinkedList<>();
        int depth = getMinimumDistance(matrix, visited, queue, N, M, 1);
        System.out.println(depth);

    }
}
