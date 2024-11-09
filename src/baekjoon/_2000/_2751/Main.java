package baekjoon._2000._2751;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int AmountsOfNumbers = Integer.parseInt(br.readLine());


        Integer[] array = new Integer[AmountsOfNumbers];

        for(int i = 0; i<AmountsOfNumbers; i++){
            Integer eachNumber = Integer.parseInt(br.readLine());
            array[i] = eachNumber;
        }

        Arrays.sort(array);

        for (Integer integer : array) {
            String s = String.valueOf(integer);
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
