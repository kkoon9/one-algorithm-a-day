package baekjoon._2000._2178_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    private static StringTokenizer st;
    private static int count = 0;
    static int[][] nodes;
    static boolean[][] visited;

    static Queue<int[]> queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int idx = 0; idx < M; idx++) {
                nodes[i][idx + 1] = str.charAt(idx) - '0';
            }
        }

        queue.add(new int[]{1,1});
        visited[1][1] = true;
        bfs();
        System.out.println(nodes[N][M]);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0];
            int y = pair[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                if (isNotMove(moveX, moveY)) continue;
                if (!visited[moveX][moveY] && nodes[moveX][moveY] != 0) {
                    visited[moveX][moveY] = true;
                    nodes[moveX][moveY] = nodes[x][y] + 1;
                    queue.add(new int[]{moveX, moveY});
                }

            }
        }
    }

    private static boolean isNotMove(int x, int y) {
        return x <= 0 || y <= 0 || x > N || y > M;
    }
}
