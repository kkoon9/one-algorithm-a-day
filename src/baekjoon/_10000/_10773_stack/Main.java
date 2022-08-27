package baekjoon._10000._10773_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int ZERO = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int value = Integer.valueOf(br.readLine());
            if(value == ZERO && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(value);
        }

        for(int value : stack) {
            answer += value;
        }

        System.out.println(answer);
    }
}
