package baekjoon._11000._11003_slidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> nodes = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            int index = i;
            int value = Integer.parseInt(st.nextToken());
            if(nodes.isEmpty() || nodes.getLast().value < value) {
                nodes.add(new Node(index,value));
            } else {
                while(!nodes.isEmpty() && nodes.getLast().value >= value) {
                    nodes.removeLast();
                }
                nodes.add(new Node(index, value));
            }
            while(!nodes.isEmpty() && nodes.getFirst().index < index - L + 1) {
                nodes.removeFirst();
            }
            sb.append(nodes.getFirst().value + " ");
        }

        System.out.println(sb.toString());
    }


    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
