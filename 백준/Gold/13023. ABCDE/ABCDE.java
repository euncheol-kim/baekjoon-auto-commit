import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = NM[0];
        int M = NM[1];

        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        boolean[] visited = new boolean[N];

        for(int i=0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        while(M-- > 0) {
            int[] AB = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int A = AB[0];
            int B = AB[1];

            adjacencyList[A].add(B);
            adjacencyList[B].add(A);
        }

        boolean condition = false;
        for(int i=0; i < visited.length; i++) {
            condition = operatedDFS(visited, adjacencyList, i, 1);
            if(condition) break;
        }

        if(condition) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean operatedDFS(boolean[] visited,
                              ArrayList<Integer>[] adjacencyList,
                              int node,
                              int depth) {

        if(depth >= 5) return true;

        visited[node] = true;

        for(int e : adjacencyList[node]) {
            boolean condition = false;

            // 방문하지 않은 경우라면
            if(!visited[e]) {
                condition = operatedDFS(visited, adjacencyList, e, depth + 1);
                if(condition) return true;
            }
        }

        visited[node] = false;
        depth -= 1;

        return false;
    }
}
