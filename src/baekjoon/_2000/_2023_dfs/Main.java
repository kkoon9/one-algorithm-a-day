package baekjoon._2000._2023_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(answer);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int number, int length) {
        if (length == N) {
            if (isPrime(number)) {
                answer.append(number).append("\n");
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) continue;
            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, length + 1);
            }
        }
    }
}
