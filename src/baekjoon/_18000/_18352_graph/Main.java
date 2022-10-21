package baekjoon._18000._18352_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int N;
    private static int M;
    private static int K;
    private static int X;
    private static int[] visit;
    private static List<Integer>[] list;
    private static List<Integer> answer;

    private static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visit = new int[N + 1];
        queue = new LinkedList<>();
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            visit[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        bfs(X);

        for (int i = 1; i <= N; i++) {
            if (visit[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int a : answer) {
                System.out.println(a);
            }
        }
    }

    private static void bfs(int x) {
        queue.add(x);
        visit[x]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                if (visit[next] == -1) {
                    visit[next] = visit[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
