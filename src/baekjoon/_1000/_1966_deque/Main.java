package baekjoon._1000._1966_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int docsCount = Integer.parseInt(st.nextToken());
            int wantedDocsOrder = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> importances = new PriorityQueue<>(Collections.reverseOrder());
            Deque<Document> documents = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int docsOrder = 0; docsOrder < docsCount; docsOrder++) {
                int importance = Integer.parseInt(st.nextToken());
                importances.add(importance);
                documents.add(Document.of(docsOrder, importance));
            }

            int maxOfImportance = importances.poll();
            int count = 0;

            while (true) {
                Document document = documents.poll();
                if (document.importance == maxOfImportance) {
                    count++;
                    if (document.order == wantedDocsOrder) {
                        break;
                    }
                    maxOfImportance = importances.poll();
                } else {
                    documents.addLast(document);
                }
            }
            answer.append(count);
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    static class Document {
        int order;
        int importance;

        public static Document of(int order, int importance) {
            Document document = new Document();
            document.order = order;
            document.importance = importance;

            return document;
        }
    }
}
