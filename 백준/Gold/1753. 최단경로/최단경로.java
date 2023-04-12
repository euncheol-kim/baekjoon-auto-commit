import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int vertex;
    public static int edge;
    public static int startNode;
    public static ArrayList<Node>[] adj;
    public static int[] routes;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ve = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        vertex = ve[0];
        edge = ve[1];

        startNode = Integer.parseInt(br.readLine());

        adj = new ArrayList[vertex + 1];
        routes = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(routes, Integer.MAX_VALUE);

        for(int i = 1; i <= edge; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = line[0];
            int to = line[1];
            int cost = line[2];

            adj[from].add(new Node(to, cost));
        }

        routes[startNode] = 0;
        setRoutes(startNode, 0);
        printRoutes();
    }

    public static void printRoutes() {
        for(int i = 1; i < routes.length; i++) {
            if(routes[i] != Integer.MAX_VALUE) {
                sb.append(routes[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void setRoutes(int cur, int cnt) {
        if(cnt == vertex) {
            return;
        }

        visited[cur] = true;

        // 갱신
        for(Node next : adj[cur]) {
            routes[next.getTargetNode()] = Math.min(
                    routes[next.getTargetNode()],
                    routes[cur] + next.getCost()
            );
        }

        // 잘못된 부분; <다음 노드의 결정>
        int tempMin = Integer.MAX_VALUE;
        for(int i = 1; i < routes.length; i++) {
            if( !visited[i] ) {
                int prev = tempMin;
                tempMin = Math.min(routes[i], tempMin);

                if( prev != tempMin){
                    cur = i;
                }
            }
        }

        setRoutes(cur, cnt + 1);
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