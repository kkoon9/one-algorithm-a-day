package baekjoon._1000._1302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String[] bookNameList = new String[N];
        for(int i = 0 ;i<N;i++) {
            bookNameList[i] = br.readLine();
        }
        Arrays.sort(bookNameList);
        Map<String, Integer> bestSeller = new LinkedHashMap<>();
        for(String bookName : bookNameList) {
            bestSeller.put(bookName, bestSeller.getOrDefault(bookName,0) + 1);
        }
        int sellingMaxCount = Integer.MIN_VALUE;
        String bestSellerName = "";
        for(String key : bestSeller.keySet()) {
            int sellingCount = bestSeller.get(key);
            if(sellingCount > sellingMaxCount) {
                sellingMaxCount = sellingCount;
                bestSellerName = key;
            }
        }
        System.out.println(bestSellerName);
    }
}
