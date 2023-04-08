import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 인원정보
    public static int m; // 파티참여자 정보
    public static int[] trueIKnow; // 진실을 알고 있는 사람의 모임
    public static int[] parent; // 자신이 속한 상단 노드를 담을 배열
    public static int[][] parties; // 파티에 참여한 사람의 정보를 담을 배열
    public static Set<Integer> trueSetTop = new HashSet<>(); // 진실을 알고있는 집합의 상단 노드를 담는 리스트

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m; 인원정보 & 파티갯수 입력 받음 [Input -> 1Line]
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        // trueIKnow; 진실을 알고 있는 사람의 모임
        // 단 첫 번째에 해당하는 인원수 정보는 skip처리하고 저장합니다.
        trueIKnow = Arrays.stream(br.readLine().split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();
        
        // parent에 초기값으로 자기 자신만을 집합으로 가진 집합들을 만듦
        parent = new int[n + 1];
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        // partires에 해당하는 이차원 배열을 만드는데, 가변 배열로 생성
        // 파티 정보에 해당하는 값이므로, 0번부터 생성진행
        parties = new int[m][];

        // 파티 정보에 대해서 입력받고
        for(int i = 0; i < m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int participants = line[0]; // 참여자 명수를 받아옴
            parties[i] = new int[participants]; // 파티자 인원이 확정되었으니, 파티자 인원만큼의 배열 크기를 생성

            // parties에 파티자 정보를 저장시킴
            for(int person = 1; person <= parties[i].length; person++) {
                parties[i][person - 1] = line[person];
            }

            // setUnion함수로 union 진행시킴
            setUnion(line);
        }

        // 진실을 알고 있는 사람들의 노드가 일관적인 parent를 가리킬 수 있도록 진행
        // 재귀를 돌면서 가장 상단의 최적 부모 노드를 가리킬 것임
        // 이후, 가장 상단의 노드를 trueSetTop에 저장
        for(int trueI : trueIKnow) {
            int temp = find(trueI);
            trueSetTop.add(temp);
        }

        // 최종적으로 구라를 칠 수 있는 최대 갯수를 반환시키는 finalSolution()을 호출하여 값을 도출
        int result = finalSolution();
        System.out.println(result);
    }

    public static int finalSolution() {
        // 만약 trueSetTop이 비어있다는 것은, 진실을 아는 사람이 아무도 없기 때문에
        // m을 반환
        if( trueSetTop.isEmpty() ) {
            return m;
        }

        // 파티 정보를 담고있는 배열을 모두 탐색하여, 구라를 칠 수 없는 모임을 구하고
        // 최대 파티수 m에서 빼주어 값을 도출
        for(int i = 0; i < parties.length; i++) {
            for(int j = 0; j < parties[i].length; j++) {
                
                // 내가 담고있는 상단 배열이, 진실을 알고있는 모임 집합 trueSetTop 포함된다면...
                if( trueSetTop.contains( find(parties[i][j])) ) {
                    m = m - 1;
                    break;
                }
            }
        }

        return m;
    }

    public static void setUnion (int[] line) {
        for(int i = 2; i < line.length; i++) {
            // 중첩이 되어 하나의 set으로 묶일것임
            setUnion(line[i - 1], line[i]);
        }
    }

    public static void setUnion(int st, int nd) {
        st = find(st);
        nd = find(nd);

        if(st < nd) {
            parent[nd] = st;
        } else {
            parent[st] = nd;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }
}