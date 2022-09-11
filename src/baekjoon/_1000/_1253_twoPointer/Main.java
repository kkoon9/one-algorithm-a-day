package baekjoon._1000._1253_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0L;
        for (int k = 0; k < N; k++) {
            long find = arr[k];
            int i = 0;
            int j = N - 1;
            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(answer);
    }

}
