package baekjoon._1000._1543;

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine(); // ababababa
        String word = br.readLine(); // aba
        int wordSize = word.length(); // 3
        int count = 0;
        while(true) {
            if(document.length() < wordSize) {
                break;
            }
            String documentElement = document.substring(0,wordSize); // bab
            if(documentElement.equals(word)) {
                count++;
                document = document.substring(wordSize); // bababa
            } else {
                document = document.substring(1); // ababa
            }
        }

        System.out.println(count);
    }
}
