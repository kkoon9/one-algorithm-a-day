package baekjoon._1000._1377_sort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            nodes[i] = new Node(i, number);
        }
        Arrays.sort(nodes);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i<N;i++) {
            if(max < nodes[i].index - i) {
                max = nodes[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    private static class Node implements Comparable<Node> {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
