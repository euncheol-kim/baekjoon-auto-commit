import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 전역변수의 설정
    public static long checkSecret;
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        // s,p; [Input -> 1Line]
        int[] sp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // dnas; dna의 정보[Input -> 2Line]
        char[] dnas = br.readLine().toCharArray();

        // passwordCondition; password 컨디션 [Input -> 3Line]
        int[] passwordCondition = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        /* 변수설정 */
        int[] partitionPasswordCondition = new int[4];
        checkSecret = Arrays.stream(passwordCondition).filter(e -> e == 0).count();
        result = 0;

        // 슬라이딩 윈도우 1구간 (초기 구간)
        for(int i = 0; i < sp[1]; i++) {
            char dna = dnas[i];
            addPartitionPasswordConditionAndCheckSecrete(dna, partitionPasswordCondition, passwordCondition);
        }

        // 슬라이딩 윈도우 1구간 만족 유무 판별
        if (checkSecret == 4) {
            result ++;
        }


        // 슬라이딩 윈도우; 2구간부터 진행
        for(int i = sp[1]; i < dnas.length; i++) {
            // loop dna정보
            int removeSpellIdx = i - sp[1];

            char lastDnaSpell = dnas[i];
            char prevDnaSpell = dnas[removeSpellIdx];

            addPartitionPasswordConditionAndCheckSecrete(lastDnaSpell, partitionPasswordCondition, passwordCondition);
            deletePartitionPasswordConditionAndCheckSecrete(prevDnaSpell, partitionPasswordCondition, passwordCondition);

            if(checkSecret == 4) {
                result ++;
            }
        }

        System.out.println(result);
    }

    private static void addPartitionPasswordConditionAndCheckSecrete(char dna,
                                                                     int[] partitionPasswordCondition,
                                                                     int[] passwordCondition) {
        switch (dna) {
            case 'A' :
                partitionPasswordCondition[0] = partitionPasswordCondition[0] + 1;
                if(partitionPasswordCondition[0] == passwordCondition[0]) {
                    checkSecret ++;
                }
                break;
            case 'C' :
                partitionPasswordCondition[1] = partitionPasswordCondition[1] + 1;
                if(partitionPasswordCondition[1] == passwordCondition[1]) {
                    checkSecret ++;
                }
                break;
            case 'G' :
                partitionPasswordCondition[2] = partitionPasswordCondition[2] + 1;
                if(partitionPasswordCondition[2] == passwordCondition[2]) {
                    checkSecret ++;
                }
                break;
            case 'T' :
                partitionPasswordCondition[3] = partitionPasswordCondition[3] + 1;
                if(partitionPasswordCondition[3] == passwordCondition[3]) {
                    checkSecret ++;
                }
                break;
        }
    }

    private static void deletePartitionPasswordConditionAndCheckSecrete(char dna,
                                                                        int[] partitionPasswordCondition,
                                                                        int[] passwordCondition) {
        switch (dna) {
            case 'A' : {
                if (partitionPasswordCondition[0] == passwordCondition[0]) {
                    checkSecret--;
                }
                partitionPasswordCondition[0] = partitionPasswordCondition[0] - 1;
                break;
            }
            case 'C' : {
                if (partitionPasswordCondition[1] == passwordCondition[1]) {
                    checkSecret--;
                }
                partitionPasswordCondition[1] = partitionPasswordCondition[1] - 1;
                break;
            }
            case 'G' : {
                if (partitionPasswordCondition[2] == passwordCondition[2]) {
                    checkSecret--;
                }
                partitionPasswordCondition[2] = partitionPasswordCondition[2] - 1;
                break;
            }
            case 'T' : {
                if (partitionPasswordCondition[3] == passwordCondition[3]) {
                    checkSecret--;
                }
                partitionPasswordCondition[3] = partitionPasswordCondition[3] - 1;
                break;
            }
        }

    }
}