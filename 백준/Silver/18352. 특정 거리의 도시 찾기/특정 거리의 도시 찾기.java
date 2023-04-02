import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] nmkx;
    public static ArrayList<Integer>[] adjList;
    public static boolean[] visited;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nmkx = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nmkx[0];
        int m = nmkx[1];
        int k = nmkx[2];
        int x = nmkx[3];

        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < m + 1; i++) {
            int[] fromTo = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList[fromTo[0]].add(fromTo[1]);
        }

        bfs(x, k, n);
    }

    public static void bfs(int node, int depth, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[node] = 0;
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] == depth) {
                result.add(curr);
            } else if (dist[curr] > depth) {
                break;
            }

            for (int next : adjList[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }
    }
}
