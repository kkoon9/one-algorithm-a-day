package baekjoon._1000._1456_prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static final int MAX_SIZE = 10000001;
    private static boolean[] primes = new boolean[MAX_SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        primes[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
            for (int prime = i + i; prime < MAX_SIZE; prime += i) {
                primes[prime] = true;
            }
        }

        for (int i = 2; i < MAX_SIZE; i++) {
            if (!primes[i]) {
                long temp = i;
                while ((double) i <= (double) N / (double) temp) {
                    if ((double) i >= (double) M / (double) temp) {
                        answer++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(answer);
    }
}
