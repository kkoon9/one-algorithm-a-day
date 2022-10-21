package baekjoon._1000._1325_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int N;
    private static int M;
    private static boolean[] visit;
    private static List<Integer>[] list;
    private static int[] hacking;

    private static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        hacking = new int[N + 1];
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (max < hacking[i]) {
                max = hacking[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (max == hacking[i]) {
                answer.append(i).append(" ");
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x) {
        queue = new LinkedList<>();
        visit = new boolean[N + 1];
        queue.add(x);
        visit[x] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                if(visit[next]) continue;
                hacking[x]++;
                visit[next] = true;
                queue.add(next);
            }
        }
    }
}
