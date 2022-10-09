package baekjoon._1000._1929_prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static final int MAX_SIZE = 1000000;
    private static boolean[] primes = new boolean[MAX_SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        primes[1] = true;
        for (int i = 2; i <= Math.sqrt(N) + 1; i++) {
            for (int prime = i + i; prime <= N; prime+=i) {
                primes[prime] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (primes[i]) continue;
            answer.append(i).append("\n");
        }

        System.out.println(answer);
    }
}
