package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pg_169199 {
}

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int width;
    private static int height;

    public int solution(String[] board) {
        int answer = 0;
        width = board.length;
        height = board[0].length();
        boolean[][] visited = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i].charAt(j) == 'R') {
                    visited[i][j] = true;
                    answer = bfs(i, j, board, visited);
                    break;
                }
            }
        }
        return answer;
    }

    int bfs(int i, int j, String[] board, boolean[][] visited) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(i, j));
        int count = 0;

        while (!queue.isEmpty()) {
            int num = queue.size();
            count++;
            for(int n = 0; n < num; n++) {
                Dot dot = queue.poll();
                visited[dot.x][dot.y] = true;

                for (int d = 0; d < 4; d++) {
                    int moveX = getMoveX(dot.x, dot.y, dx[d], board);
                    int moveY = getMoveY(dot.x, dot.y, dy[d], board);
                    System.out.println(moveX + " " + moveY);
                    if (isLimit(moveX, moveY)) {
                        continue;
                    }
                    if (visited[moveX][moveY]) {
                        continue;
                    }
                    visited[moveX][moveY] = true;
                    if (board[moveX].charAt(moveY) == 'G') {
                        return count;
                    }
                    queue.add(new Dot(moveX, moveY));
                }
            }
            System.out.println("=============");
        }

        return -1;
    }

    private int getMoveX(int x, int y, int moving, String[] board) {
        if (moving == 0) {
            return x;
        }

        while (true) {
            if (isLimit(x, y) || board[x].charAt(y) == 'D') {
                break;
            }
            x += moving;
        }

        return x - moving;
    }

    private int getMoveY(int x, int y, int moving, String[] board) {
        if (moving == 0) {
            return y;
        }

        while (true) {
            if (isLimit(x, y) || board[x].charAt(y) == 'D') {
                break;
            }
            y += moving;
        }

        return y - moving;
    }

    private boolean isLimit(int x, int y) {
        return x < 0 || y < 0 || x >= width || y >= height;
    }

    class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}