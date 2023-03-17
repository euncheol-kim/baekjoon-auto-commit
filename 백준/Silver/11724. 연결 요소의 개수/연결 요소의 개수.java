import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static ArrayList<Integer>[] adjacencyList;
    public static boolean[] visited;
    public static int result = 0;

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m; [Input -> 1 Line]
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nm[0];
        int m = nm[1];


        visited = new boolean[n + 1];
        adjacencyList = new ArrayList[n + 1];
        for(int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= m; i++) {
            int[] uv = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 무방향 그래프이기 때문에 양 방향으로 저장
            adjacencyList[uv[0]].add(uv[1]);
            adjacencyList[uv[1]].add(uv[0]);
        }

        for(int i = 1; i <= n; i++) {
            // 방문하지 않았다면 DFS연산 진행 -> 연산이 끝났다는 의미는 하나의 연결 요소가 됨을 의미한다.
            if(! visited[i] ) {
                operatedDFS(i);
                result ++;
            }
        }

        System.out.println(result);
    }

    public static void operatedDFS(int node) {
        // node를 방문했다면 -> 종료
        if(visited[node]) {
            return;
        }

        // 방문했음을 표시
        visited[node] = true;
        // 엘리먼트 값을 DFS진행
        for(int i : adjacencyList[node]) {
            if(visited[i] == false) {
                operatedDFS(i);
            }
        }
    }
}