package baekjoon._11000._11286_queue;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final String EMPTY = "0\n";

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number > 0) {
                nodes.add(new Node(number, false));
            } else if (number < 0) {
                nodes.add(new Node(-1 * number, true));
            } else {
                if(nodes.isEmpty()) {
                    answer.append(EMPTY);
                } else {
                    answer.append(nodes.poll().getValue()).append("\n");
                }
            }
        }
        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
        private int value;
        private boolean isMinus;

        public Node(int value, boolean isMinus) {
            this.value = value;
            this.isMinus = isMinus;
        }

        public int getValue() {
            return isMinus ? value * -1 : value;
        }
        @Override
        public int compareTo(@NotNull Node o) {
            int compare = this.value - o.value;
            if (compare == 0) {
                compare = this.isMinus ? -1 : 1;
            }
            return compare;
        }
    }
}
