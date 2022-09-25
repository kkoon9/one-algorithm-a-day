package baekjoon._1000._1260_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    static List<Integer>[] nodes;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for(int i = 1;i<=N;i++) {
            Collections.sort(nodes[i]);
        }

        dfs(V);
        System.out.println();
        visitedClear(N);
        queue.add(V);
        bfs();
    }

    private static void visitedClear(int size) {
        for (int i = 1; i <= size; i++) {
            visited[i] = false;
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;
            System.out.print(v + " ");
            for (int node : nodes[v]) {
                if (!visited[node]) {
                    queue.add(node);
                }
                visited[node] = true;
            }
        }
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        System.out.print(v + " ");

        visited[v] = true;
        for (int node : nodes[v]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
