import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int m;

    public static StringBuilder sb = new StringBuilder();
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        // parents; 1 ~ n + 1 범위 할당진행
        parents = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < m; i ++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int what = line[0];

            // 합치는 경우
            if( what == 0 ) {
                // union(@param node1, node2); 합치는 함수 호출
                union(line[1], line[2]);

            } else if( what == 1 ) {
                printYN(line[1], line[2]);
            }
        }

        System.out.println(sb);

    }
    public static void printYN(int st, int nd) {
        if(find(st) == find(nd)) {
            sb.append("YES").append("\n");

        } else{
            sb.append("NO").append("\n");
        }
    }
    public static int find(int x) {
        if( x == parents[x] ) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    public static void union(int st, int nd) {
        st = find(st);
        nd = find(nd);

        // 가장 상단 노드를 가장 작은 값으로 맞춰놓기
        if(st < nd) {
            parents[nd] = st;
        } else {
            parents[st] = nd;
        }
    }
}
