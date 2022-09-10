package baekjoon._2000._2018_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getAnswer(N));
    }

    private static long getAnswer(int N) {
        long answer = 1L;
        if (N == 1) {
            return 1L;
        }
        int pointer1 = 1;
        int pointer2 = 1;
        int sum = 1;

        while (pointer1 != N) {
            if (sum == N) {
                answer++;
                pointer1++;
                sum += pointer1;
            } else if (sum > N) {
                sum -= pointer2;
                pointer2++;
            } else {
                pointer1++;
                sum += pointer1;
            }
        }
        return answer;
    }
}
