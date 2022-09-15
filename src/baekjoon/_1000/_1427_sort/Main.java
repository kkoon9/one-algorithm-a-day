package baekjoon._1000._1427_sort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();
        for(char ch : str.toCharArray()) {
            list.add(ch - '0');
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int number : list) {
            System.out.print(number);
        }
    }
}
