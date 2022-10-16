package baekjoon._11000._11689_euler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long result = N;

        for(long p = 2; p <=Math.sqrt(N); p++) {
            if (N % p == 0) {
                result = result - result / p;
                while (N % p == 0) {
                    N /= p;
                }
            }
        }
        if (N > 1) {
            result = result - result / N;
        }

        System.out.println(result);
    }
}
