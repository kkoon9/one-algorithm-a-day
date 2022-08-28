package baekjoon._14000._14502_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static int answer = -1;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int N;
    private static int M;
    private static boolean[][] visit;

    private static Queue<Dot> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Dot> blankDots = new ArrayList<>();
        List<Dot> virusDots = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == BLANK) {
                    blankDots.add(Dot.of(i, j));
                }

                if (map[i][j] == VIRUS) {
                    virusDots.add(Dot.of(i, j));
                }
            }
        }

        for (int i = 0; i < blankDots.size(); i++) {
            Dot first = blankDots.get(i);
            map[first.x][first.y] = WALL;
            for (int j = i + 1; j < blankDots.size(); j++) {
                Dot second = blankDots.get(j);
                map[second.x][second.y] = WALL;
                for (int k = j + 1; k < blankDots.size(); k++) {
                    Dot third = blankDots.get(k);
                    map[third.x][third.y] = WALL;
                    queue = new LinkedList<>();
                    visit = new boolean[N + 1][M + 1];
                    for (Dot dot : virusDots) {
                        queue.add(dot);
                    }
                    int[][] test = new int[N][M];
                    for (int n = 0; n < N; n++) {
                        for (int m = 0; m < M; m++) {
                            test[n][m] = map[n][m];
                        }
                    }
                    bfs(test);
                    map[third.x][third.y] = BLANK;
                }
                map[second.x][second.y] = BLANK;
            }
            map[first.x][first.y] = BLANK;
        }

        System.out.println(answer);
    }

    private static void bfs(int[][] map) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                Dot v = queue.poll();
                int x = v.x;
                int y = v.y;
                for (int d = 0; d < 4; d++) {
                    int moveX = x + dx[d];
                    int moveY = y + dy[d];
                    if (isLimit(moveX, moveY)) continue;
                    if (visit[moveX][moveY]) continue;
                    visit[moveX][moveY] = true;
                    if (map[moveX][moveY] == WALL) continue;
                    map[moveX][moveY] = VIRUS;
                    queue.add(Dot.of(moveX, moveY));
                }
            }
        }
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == BLANK) {
                    safeArea++;
                }
            }
        }
        answer = Math.max(answer, safeArea);
    }

    private static boolean isLimit(int moveX, int moveY) {
        return moveX < 0 || moveY < 0 || moveX >= N || moveY >= M;
    }

    static class Dot {
        private int x;
        private int y;

        public static Dot of(int x, int y) {
            Dot dot = new Dot();
            dot.x = x;
            dot.y = y;

            return dot;
        }
    }
}
