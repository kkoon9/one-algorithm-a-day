package baekjoon._1000._1874_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final String PUSH = "+\n";
    private static final String POP = "-\n";
    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sequence = 1;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            while(sequence <= value) {
                stack.push(sequence++);
                answer.append(PUSH);
            }
            if(!stack.isEmpty() && stack.peek() == value) {
                stack.pop();
                answer.append(POP);
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(answer);
    }
}
