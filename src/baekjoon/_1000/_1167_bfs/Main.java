package baekjoon._1000._1167_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    static List<Edge>[] nodes;
    static boolean[] visited;
    static int[] distances;

    private static final int END = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distances = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == END) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                nodes[node].add(new Edge(e,v));
            }
        }

        bfs(1);
        int max = 1;
        for(int i =2;i<=N;i++) {
            if(distances[max] < distances[i]) {
                max = i;
            }
        }
        distances = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(max);
        Arrays.sort(distances);
        System.out.println(distances[N]);
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(Edge edge : nodes[now]) {
                int e = edge.e;
                int v = edge.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distances[e] = distances[now] + v;
                }
            }
        }
    }

    static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
