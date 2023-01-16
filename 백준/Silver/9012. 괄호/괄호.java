import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputLine = Integer.parseInt(br.readLine());
        Stack<Character> items = new Stack<>();

        Solution s = new Solution(items, inputLine, br);

        s.solution();
    }
}
class Solution {
    private BufferedReader br;
    public Stack<Character> stack;
    private final int INPUT_LINE;

    public Solution(Stack<Character> stack, int inputLine, BufferedReader br){
        this.stack = stack;
        this.INPUT_LINE = inputLine;
        this.br = br;
    }

    public void solution() throws IOException {
        List<String> result = new ArrayList<>();

        int cnt = INPUT_LINE;
        while(0 < cnt) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String temp = br.readLine();
            String checked = checkedCondition(temp);

            // 결과 넣어주기
            result.add(checked);

            // stack clear
            stack.clear();

            // 기저조건
            cnt -= 1;
        }

        printResult(result);
    }

    // 결과반환
    private void printResult(List<String> result) {
        for(String e : result) {
            System.out.println(e);
        }
    }

    // 결과값 저장
    public String checkedCondition(String parentheses) {
        for(int i = 0; i < parentheses.length(); i++) {
            // '(' 라면 푸쉬
            if(parentheses.charAt(i) == '(') {
                stack.push(parentheses.charAt(i));
                // ')' 라면...
            } else {
                // [1] stack의 비어있는지 확인
                if(stack.isEmpty()) return "NO";
                // [2] 안비어있다면, pop
                stack.pop();
            }
        }

        String result = stack.isEmpty() ? "YES" : "NO";

        return result;
    }
}