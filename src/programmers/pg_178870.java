package programmers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pg_178870 {
    public static void main(String[] args) {
        int[] sequence = new int[]{1, 2, 3, 4, 5};
        int k = 7;
        int[] result = solution(sequence, k);

        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minRange = Integer.MAX_VALUE;
        int sum = 0;
        int leftPoint = 0, rightPoint = 0;
        while(true) {
            if(sum >= k) {
                sum -= sequence[leftPoint++];
            }
            else if(rightPoint >= sequence.length) {
                break;
            } else {
                sum += sequence[rightPoint++];
            }

            if(sum == k) {
                if(minRange > rightPoint-leftPoint) {
                    minRange = rightPoint-leftPoint;
                    answer[0] = leftPoint;
                    answer[1] = rightPoint - 1;
                }
            }
        }
        return answer;
    }
}
