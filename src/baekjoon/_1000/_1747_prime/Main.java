package baekjoon._1000._1747_prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    private static final int MAX_SIZE = 10000001;
    private static boolean[] primes = new boolean[MAX_SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        primes[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
            for (int prime = i + i; prime < MAX_SIZE; prime+=i) {
                primes[prime] = true;
            }
        }
        int answer = N;
        while(true) {
            if(!primes[N] && isPalindrome(N)) {
                answer = N;
                break;
            }
            N++;
        }
        System.out.println(answer);
    }

    private static boolean isPalindrome(int num) {
        return num == reverse(num);
    }

    private static int reverse(int num) {
        StringBuilder sb = new StringBuilder();
        return Integer.valueOf(sb.append(num).reverse().toString());
    }
}
