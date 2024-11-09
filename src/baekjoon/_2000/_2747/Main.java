package baekjoon._2000._2747;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = Integer.parseInt(br.readLine());
        int[] arr = new int[index+1];

        // 55번째 수 0~ 55
        for (int i = 0; i < index+1; i++) {

            if (i == 0 || i == 1) {
                arr[i] = i;
            }else{
                arr[i] = arr[i-1]+arr[i-2];
            }
        }

        String value = String.valueOf(arr[index]);
        bw.write(value);

        bw.flush();
        bw.close();
        br.close();
    }
}
