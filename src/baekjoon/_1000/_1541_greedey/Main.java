package baekjoon._1000._1541_greedey;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String expression = br.readLine();
        String[] arr = expression.split("-");
        for(int i = 0;i<arr.length;i++) {
            String[] expressionArrInArr = arr[i].split("\\+");
            int sum = 0;
            for(int j = 0; j< expressionArrInArr.length;j++) {
                sum += Integer.parseInt(expressionArrInArr[j]);
            }
            if(i == 0){
                answer += sum;
            } else {
                answer -= sum;
            }

        }

        System.out.println(answer);
    }
}
