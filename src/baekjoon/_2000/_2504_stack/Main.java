package baekjoon._2000._2504_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final char SMALL_LEFT_BRACKET = '(';
    private static final char SMALL_RIGHT_BRACKET = ')';
    private static final char BIG_LEFT_BRACKET = '[';
    private static final char BIG_RIGHT_BRACKET = ']';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = getAnswer(input);
        System.out.println(answer);
    }

    private static int getAnswer(String input) {
        Stack<Character> brackets = new Stack<>();
        int answer = 0;
        int sum = 1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case SMALL_LEFT_BRACKET:
                    sum *= 2;
                    brackets.push(ch);
                    break;
                case BIG_LEFT_BRACKET:
                    sum *= 3;
                    brackets.push(ch);
                    break;
                case SMALL_RIGHT_BRACKET:
                    if (brackets.isEmpty() || brackets.pop() != SMALL_LEFT_BRACKET) {
                        return 0;
                    }
                    if (input.charAt(i - 1) == SMALL_LEFT_BRACKET)
                        answer += sum;
                    sum /= 2;
                    break;
                case BIG_RIGHT_BRACKET:
                    if (brackets.isEmpty() || brackets.pop() != BIG_LEFT_BRACKET) {
                        return 0;
                    }
                    if (input.charAt(i - 1) == BIG_LEFT_BRACKET)
                        answer += sum;
                    sum /= 3;
                    break;
            }
        }
        if(!brackets.isEmpty()){
            return 0;
        }
        return answer;
    }
}
