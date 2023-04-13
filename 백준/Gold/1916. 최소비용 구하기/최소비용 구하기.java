import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int n; // 도시 개수
    public static int m; // 버스 개수
    public static ArrayList<Node>[] adj; // 인접리스트를 저장할 배열
    public static int[] shortest; // 최소 경로를 저장할 배열
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 인접리스트, 최소 경로 저장 배열, 방문배열 초기화 진행 및
        // 2번째 라인부터 마지막 라인전까지 입력받기
        visited = new boolean[n + 1];

        shortest = new int[n + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);

        adj = new ArrayList[n + 1];
        for(int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        // 인접리스트 저장 진행
        for(int i = 1; i <= m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = line[0];
            int end = line[1];
            int cost = line[2];

            Node node = new Node(end, cost);
            adj[start].add(node);
        }

        // 마지막 라인 입력받기
        int[] question = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = question[0];
        int end = question[1];

        shortest[start] = 0;
        // 다익스트라 알고리즘 사용하여 문제값 도출
        setShortest(start, 0);
        printFinalSolution(end);
    }
    public static void printFinalSolution(int end) {
        System.out.println(shortest[end]);
    }

    public static void setShortest(int node, int cnt) {
        if( n == cnt) {
            return;
        }

        visited[node] = true;

        // 최소값의 갱신
        for(Node next : adj[node]) {
            shortest[next.getTargetNode()] = Math.min(
                    shortest[next.targetNode],
                    shortest[node] + next.getCost()
            );
        }

        // 최저값 설정
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i < shortest.length; i++) {
            if ( !visited[i] ) {
                int prev = minValue;
                minValue = Math.min(minValue, shortest[i]);

                if( prev != minValue ) {
                    node = i;
                }
            }
        }

        setShortest(node, cnt + 1);
    }
}

class Node {
    int targetNode;
    int cost;

    private Node(){}
    public Node(int targetNode, int cost) {
        this.targetNode = targetNode;
        this.cost = cost;
    }

    public int getTargetNode() {
        return this.targetNode;
    }

    public int getCost() {
        return this.cost;
    }
}