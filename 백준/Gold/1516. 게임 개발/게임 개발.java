import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; // 진입차수배열
        int[] selfBuild = new int[N + 1]; // 자기자신을 짓는데 걸리는 시간
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken()); // 해당 건물을 짓기 위한 시간
            while (true) { // 인접리스트 초기화
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1)
                    break;
                A.get(preTemp).add(i);
                indegree[i]++; // 진입차수 배열 초기화
            }
        }
        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A.get(now)) {
                indegree[next]--;
                /*선행되어야 하는 건물을 모두 짓는 데 필요한 최소 시간은, 
                해당 건물을 짓기 위해 필요한 시간과 
                선행되어야 하는 건물들을 모두 짓는 데 필요한 최소 시간 중 큰 값입니다.*/
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}