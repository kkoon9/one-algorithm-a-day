package baekjoon._2000._2750_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            answer.append(arr[i]).append("\n");
        }

        System.out.println(answer);
    }
}
