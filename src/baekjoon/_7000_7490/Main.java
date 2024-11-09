package baekjoon._7000_7490;

import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loopNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < loopNum; i++) {
            N = Integer.parseInt(br.readLine());
            if(i!=0){
                sb.append("\n");
            }
            dfsCalculation(1, 1, 0, "1");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    //재귀 함수
    //인덱스가 N이 될때까지 모든 식과 결과 값을 구하고
    //N이 되면 결과값이 0인거의 식을 StringBuilder에 넣는다.
    private static void dfsCalculation(int idx, int result, int previousResult, String expressionTheResult) {

        if(idx == N){

            if (result == 0) {
                sb.append(expressionTheResult + "\n");
            }

        }else {

            int a;
            String nextValue = String.valueOf(idx + 1);
            if(result-previousResult < 0){
                a = ((result - previousResult) * 10) - (idx + 1);
            }else {
                a = ((result - previousResult) * 10) + (idx + 1);
            }
            dfsCalculation(idx + 1, previousResult + a, result, expressionTheResult + " " + nextValue);
            dfsCalculation(idx + 1, result + (idx + 1), result, expressionTheResult + "+" + nextValue);
            dfsCalculation(idx + 1, result - (idx + 1), result, expressionTheResult + "-" + nextValue);

        }
    }

}
