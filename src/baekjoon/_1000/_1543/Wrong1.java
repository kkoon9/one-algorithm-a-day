package baekjoon._1000._1543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Wrong1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();
        String searchWord = br.readLine();
        int answer = 0;

        while (words.contains(searchWord)) {
            words = words.replaceFirst(searchWord, "");
            answer++;
        }
        System.out.println(answer);
    }
}