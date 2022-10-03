package baekjoon._11000._11047_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int presentPrice = K;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (presentPrice == 0) break;
            while (presentPrice >= num) {
                presentPrice -= num;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
