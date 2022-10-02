package baekjoon._1000._1920_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int search = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int number = arr[mid];
                if (number > search) {
                    end = mid - 1;
                } else if (number < search) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                answer.append("1\n");
            } else {
                answer.append("0\n");
            }
        }
        System.out.println(answer);
    }
}
