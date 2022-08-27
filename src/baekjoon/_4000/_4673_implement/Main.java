package baekjoon._4000._4673_implement;

public class Main {
    private static final int SIZE = 10000;

    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();

        boolean[] selfNumbers = new boolean[SIZE + 1];

        for (int i = 1; i <= SIZE; i++) {
            int sum = i;
            String str = String.valueOf(i);
            for (int index = 0; index < str.length(); index++) {
                sum += str.charAt(index) - '0';
            }
            if (sum > SIZE) continue;
            selfNumbers[sum] = true;
        }

        for (int i = 1; i <= SIZE; i++) {
            if (!selfNumbers[i]) {
                answer.append(i);
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }
}
