import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] inDegree;
    public static ArrayList<Integer>[] adjList;
    public static int n;
    public static int m;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1Line; n, m 입력받기
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        inDegree = new int[n + 1];

        // adjList의 초기화 진행
        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2Line~ : 학생1번이 학생2번보다 앞에있는 조건에 대한 입력받기
        for(int i = 0; i < m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 진입차수에 대한 inDegree진행
            inDegree[line[1]] = inDegree[line[1]] + 1;
            // 인접리스트 할당진행
            adjList[line[0]].add(line[1]);
        }

        // 다 전역변수여서 따로 파라메터로 넘기지 않음
        operated();
    }

    public static void operated() {
        Queue<Integer> queue = new LinkedList<>();

        // queue에 진입차수가 0인 친구들 add 처리진행
        for(int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }


        while( !queue.isEmpty() ) {
            int cur = queue.poll();
            // 현재 노드를 결과 배열에 저장한다.
            result.add(cur);

            // 인접리스트의 순회진행
            for(int i = 0; i < adjList[cur].size(); i ++) {
                int node = adjList[cur].get(i);
                inDegree[node] = inDegree[node] - 1;

                if( inDegree[node] == 0 ) {
                    queue.add(node);
                }
            }
        }

        for(int e : result) {
            System.out.printf(e + " ");
        }
    }
}