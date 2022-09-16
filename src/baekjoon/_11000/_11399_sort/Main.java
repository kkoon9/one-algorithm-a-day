package baekjoon._11000._11399_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        long answer = 0L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int size = arr.length;
        for(int i = 0 ;i<N;i++) {
            size--;
            answer += arr[i];
            answer += size * arr[i];
        }
        System.out.println(answer);
    }
}
