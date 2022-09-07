package baekjoon._11000._11660_prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] arr = new long[N + 2][N + 2];
        long[][] prefixSumArr = new long[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSumArr[i][j] = prefixSumArr[i][j - 1] + prefixSumArr[i - 1][j] + arr[i][j] - prefixSumArr[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            answer.append(prefixSumArr[x2][y2] - prefixSumArr[x1 - 1][y2] - prefixSumArr[x2][y1 - 1] + prefixSumArr[x1 - 1][y1 - 1]);
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
