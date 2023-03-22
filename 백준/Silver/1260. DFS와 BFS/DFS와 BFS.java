import java.util.*;
import java.io.*;


public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjacencyList;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // nmv; Input 1Line
        int[] nmv = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nmv[0]; // 노드 개수
        int m = nmv[1]; // 간선 개수
        int v = nmv[2]; // 출발 위치

        // adjacencyList, visited
        adjacencyList = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // adjacencyList 값 할당 진행.. 배열의 위치는 0부터 진행
        for(int i = 0; i < m; i++) {
            int[] fromTo = Arrays.stream(br.readLine().split( " "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjacencyList[fromTo[0] - 1].add(fromTo[1] - 1);
            adjacencyList[fromTo[1] - 1].add(fromTo[0] - 1);
        }
        
        for(int i = 0; i < n; i++) {
            Collections.sort(adjacencyList[i]);
        }
        
        printDFS(adjacencyList, v - 1);
        Arrays.fill(visited, false);
        printBFS(adjacencyList, v - 1);
    }

    public static void printBFS(ArrayList<Integer>[] adjacencyList, int startNode) {
        StringBuilder sb = new StringBuilder();
        operatedBFS(adjacencyList, startNode, sb);
        System.out.println(sb);
    }

    public static void operatedBFS(ArrayList<Integer>[] adjacencyList, int startNode, StringBuilder sb) {
        visited[startNode] = true;
        queue.add(startNode);

        while( !queue.isEmpty() ) {
            int curNode = queue.remove(); // NPE 발생시 중단
            sb.append(curNode + 1).append(" ");

            for(int next : adjacencyList[curNode]) {
                if( !visited[next] ) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

    }

    public static void printDFS(ArrayList<Integer>[] adjacencyList, int startNode) {
        StringBuilder sb = new StringBuilder();
        operatedDFS(adjacencyList, startNode, sb);
        System.out.println(sb);
    }

    public static void operatedDFS(ArrayList<Integer>[] adjacencyList, int startNode, StringBuilder sb){
        visited[startNode] = true;
        sb.append(startNode + 1).append(" ");

        for(int next : adjacencyList[startNode]) {
            if( !visited[next] ) {
                operatedDFS(adjacencyList, next, sb);
            }
        }
    }
}