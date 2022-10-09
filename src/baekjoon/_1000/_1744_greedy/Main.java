package baekjoon._1000._1744_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int one = 0, zero = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number > 1) {
                plus.add(number);
            } else if (number == 1) {
                one++;
            } else if (number == 0) {
                zero++;
            } else {
                minus.add(number);
            }
        }

        // plus 처리
        while (plus.size() > 1) {
            int first = plus.poll();
            int second = plus.poll();
            answer += first * second;
        }

        if(!plus.isEmpty()) {
            answer += plus.poll();
        }

        // minus 처리
        while (minus.size() > 1) {
            int first = minus.poll();
            int second = minus.poll();
            answer += first * second;
        }

        if(!minus.isEmpty()) {
            if(zero == 0) {
                answer += minus.poll();
            }
        }

        answer += one;

        System.out.println(answer);
    }
}
