package baekjoon._11000._11659_prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        int[] prefixSumArr = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSumArr[i] = prefixSumArr[i -1] + arr[i];
        }

        for (int i = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            answer.append(prefixSumArr[second] - prefixSumArr[first - 1]);
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
