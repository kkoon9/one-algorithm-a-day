package baekjoon._2000._2108_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static final int SIZE = 4000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        double sum = 0.0f;
        int median;
        long arithmeticMean;
        int range;
        int frequency;
        Frequency[] frequencys = new Frequency[SIZE * 2 + 2];

        for(int i = 0;i<SIZE * 2 + 2;i++){
            int number = i;
            if(number > SIZE) {
                number -= SIZE;
                number = -number;
            }
            frequencys[i] = new Frequency(number,0);
        }

        for(int i = 0 ; i<N;i++){
            numbers[i] = Integer.parseInt(br.readLine());
            sum += (float)numbers[i];
            if(numbers[i] <0)
                frequencys[Math.abs(numbers[i]) + SIZE].frequency++;
            else
                frequencys[numbers[i]].frequency++;
        }

        Arrays.sort(numbers);
        Arrays.sort(frequencys);

        frequency = frequencys[0].number;

        if(N > 1 && frequencys[0].frequency == frequencys[1].frequency){
            frequency = frequencys[1].number;
        }

        arithmeticMean = Math.round(sum/(float)N);
        median = numbers[N/2];
        range = numbers[N-1] - numbers[0];

        System.out.println(arithmeticMean);
        System.out.println(median);
        System.out.println(frequency);
        System.out.println(range);
    }
    private static class Frequency implements Comparable<Frequency> {
        int number;
        int frequency;
        Frequency(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Frequency o) {
            int result = o.frequency - this.frequency;
            if(result==0){
                result = this.number - o.number;
            }
            return result;
        }
    }
}
