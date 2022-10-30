package baekjoon._1000._1707_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static boolean visited[];
    private static int checked[];
    private static List<Integer> arr[];

    private static boolean answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            answer = true;
            visited = new boolean[V + 1];
            checked = new int[V + 1];
            arr = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }

            for(int i = 1;i<=V;i++) {
                if(answer) {
                    dfs(i);
                } else {
                    break;
                }
            }

            if(answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for(int i: arr[node]) {
            if(!visited[i]) {
                checked[i] = (checked[node] + 1) % 2;
                dfs(i);
            } else if(checked[node] == checked[i]) {
                answer = false;
            }
        }
    }
}
