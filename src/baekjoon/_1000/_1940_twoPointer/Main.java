package baekjoon._1000._1940_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(getAnswer(arr, M));
    }

    private static int getAnswer(int[] arr, int M) {
        int answer = 0;
        int pointer1 = 0;
        int pointer2 = arr.length - 1;
        while (pointer1 != pointer2) {
            int sum = arr[pointer1] + arr[pointer2];
            if (sum == M) {
                answer++;
                pointer1++;
            } else if (sum > M) {
                pointer2--;
            } else {
                pointer1++;
            }
        }
        return answer;
    }
}
