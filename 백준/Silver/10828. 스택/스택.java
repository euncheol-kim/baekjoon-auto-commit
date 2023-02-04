import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack stack = new Stack();
        stack.solution();
    }
}

class Stack {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws Exception{
        int line = Integer.parseInt(br.readLine());

        String[] operations = new String[line];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < line; i++) {
            operations[i] = br.readLine();
        }

        checkOperation(operations, result);

    }

    public void checkOperation(String[] operations, List<Integer> result) {

        for(int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");

            switch (operation[0]) {
                case "push":
                    setPush(operation[1], result);
                    break;
                case "top":
                    System.out.println(getTop(result));
                    break;
                case "empty":
                    System.out.println(setEmpty(result));
                    break;
                case "pop":
                    System.out.println(getPop(result));
                    break;
                case "size":
                    System.out.println(setSize(result));
                    break;
            }
        }
    }

    public int setEmpty(List<Integer> result) {
        if(setSize(result) <= 0 ) {
            return 1;
        }

        return 0;
    }

    public int setSize(List<Integer> result) {
        return result.size();
    }

    public int getPop(List<Integer> result) {
        if(setSize(result) <= 0 ) {
            return -1;
        }

        return result.remove(result.size() - 1);
    }

    public int getTop(List<Integer> result) {
        if(setSize(result) <= 0 ) {
            return -1;
        }

        return result.get(result.size() - 1);
    }

    public void setPush(String operation, List<Integer> result) {
        result.add(Integer.parseInt(operation));
    }
}
