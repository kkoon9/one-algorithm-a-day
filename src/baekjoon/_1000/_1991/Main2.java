package baekjoon._1000._1991;

import java.util.*;
import java.io.*;

public class Main2 {
    static Map<String, Node> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        map = new HashMap<>();
        for(int i = 0 ;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            map.put(root, new Node(root, left, right));
        }
        printPreOrder(map.get("A"));
        System.out.println();
        printInOrder(map.get("A"));
        System.out.println();
        printPostOrder(map.get("A"));
    }

    private static void printPreOrder(Node node) {
        System.out.print(node.root);
        if (!node.left.equals(".")) {
            printPreOrder(map.get(node.left));
        }
        if (!node.right.equals(".")) {
            printPreOrder(map.get(node.right));
        }
    }

    private static void printInOrder(Node node) {
        if (!node.left.equals(".")) {
            printInOrder(map.get(node.left));
        }
        System.out.print(node.root);
        if (!node.right.equals(".")) {
            printInOrder(map.get(node.right));
        }
    }
    private static void printPostOrder(Node node) {
        if (!node.left.equals(".")) {
            printPostOrder(map.get(node.left));
        }
        if (!node.right.equals(".")) {
            printPostOrder(map.get(node.right));
        }
        System.out.print(node.root);
    }

    static class Node {
        String root;
        String left;
        String right;

        Node(String root, String left, String right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}
