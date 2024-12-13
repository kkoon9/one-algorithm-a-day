package baekjoon._1000._1991;

import java.io.*;

public class Main {

    static final Node head = new Node("A",null,null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int loopNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < loopNum; i++) {
            String[] rootLeftRight = br.readLine().split(" ");
            insertNode(head, rootLeftRight[0], rootLeftRight[1], rootLeftRight[2]);
        }

        printFirstLoop(sb,head);
        sb.append("\n");
        printMiddleLoop(sb,head);
        sb.append("\n");
        printLastLoop(sb,head);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * ABDCEFG
     * DBAECFG
     * DBEGFCA
     */
    private static void printFirstLoop(StringBuilder sb, Node node) {
        if(node != null) {
            sb.append(node.getRootData());
            if(node.getLeft() != null&&!node.getLeft().getRootData().equals(".")) {
                printFirstLoop(sb, node.getLeft());
            }
            if(node.getRight() != null&&!node.getRight().getRootData().equals(".")) {
                printFirstLoop(sb, node.getRight());
            }
        }
    }

    private static void printMiddleLoop(StringBuilder sb, Node node) {
        if(node != null) {
            if(node.getLeft() != null&&!node.getLeft().getRootData().equals(".")) {
                printMiddleLoop(sb, node.getLeft());
            }
            sb.append(node.getRootData());
            if(node.getRight() != null&&!node.getRight().getRootData().equals(".")) {
                printMiddleLoop(sb, node.getRight());
            }
        }
    }

    private static void printLastLoop(StringBuilder sb, Node node) {
        if(node != null) {
            if(node.getLeft() != null&&!node.getLeft().getRootData().equals(".")) {
                printLastLoop(sb, node.getLeft());
            }
            if(node.getRight() != null&&!node.getRight().getRootData().equals(".")) {
                printLastLoop(sb, node.getRight());
            }
            sb.append(node.getRootData());
        }
    }


    private static void insertNode(Node headNode, String root, String left, String right) {
        if (headNode.getRootData().equals(root)) {
            headNode.setLeft(new Node(left, null, null));
            headNode.setRight(new Node(right, null, null));
        }else{
            if(headNode.getLeft()!=null){
                insertNode(headNode.getLeft(), root, left, right);
            }
            if(headNode.getRight()!=null){
                insertNode(headNode.getRight(), root, left, right);
            }
        }
    }



    static class Node{
        String rootData;
        Node left;
        Node right;

        public Node(String rootData, Node left, Node right) {
            this.rootData = rootData;
            this.left = left;
            this.right = right;
        }

        public String getRootData() {
            return rootData;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
