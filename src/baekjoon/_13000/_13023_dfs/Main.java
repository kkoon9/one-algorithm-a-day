package baekjoon._13000._13023_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    static List<Integer>[] nodes;
    static boolean answer = false;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if(answer) {
                break;
            }
        }

        System.out.println(answer? "1" : "0");
    }

    private static void dfs(int v, int length) {
        if (length == 5 || answer) {
            answer = true;
            return;
        }

        visited[v] = true;
        for (int node : nodes[v]) {
            if (!visited[node]) {
                dfs(node, length + 1);
            }
        }
        visited[v] = false;
    }
}
