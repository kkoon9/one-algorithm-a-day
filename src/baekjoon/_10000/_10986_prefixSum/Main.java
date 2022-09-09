package baekjoon._10000._10986_prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[N];
        long[] remainders = new long[M];
        st = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArr[i] % M);
            if (remainder == 0) answer++;
            remainders[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainders[i] > 1) {
                answer = answer + (remainders[i] * (remainders[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
