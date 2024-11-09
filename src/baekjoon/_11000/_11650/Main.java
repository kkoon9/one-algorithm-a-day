package baekjoon._11000._11650;

import java.io.*;
import java.util.*;

//public class Main {
//
//    public static void main(String[] args) throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        Integer initialLoop  = Integer.parseInt(br.readLine());
//
//        HashMap<Integer, List<Integer>> integerListHashMap = new HashMap<>();
//
//        for(int i = 0; i<initialLoop; i++){
//
//            String s = br.readLine();
//            String[] split = s.split(" ");
//            String firstNum = split[0];
//            String secondNum = split[1];
//
//            if (integerListHashMap.get(Integer.parseInt(firstNum)) == null) {
//                ArrayList<Integer> integers = new ArrayList<>();
//                integers.add(Integer.parseInt(secondNum));
//                integerListHashMap.put(Integer.parseInt(firstNum), integers);
//            }else {
//                List<Integer> integers = integerListHashMap.get(Integer.parseInt(firstNum));
//                integers.add(Integer.parseInt(secondNum));
//                integerListHashMap.put(Integer.parseInt(firstNum), integers);
//            }
//
//        }
//
//        //set으로는 정렬을 할 수 없으므로 List로 변환한다.
//        Set<Integer> integers = integerListHashMap.keySet();
//        ArrayList<Integer> keysList = new ArrayList<>(integers);
//        Collections.sort(keysList);
//
//
//        //결과 담는 곳
//        StringBuilder sb = new StringBuilder();
//
//        for (Integer key : keysList) {
//            List<Integer> values = integerListHashMap.get(key);
//            if (values.size() > 1) {
//                Collections.sort(values);
//                for (Integer value : values) {
//                    String result = key + " " + value;
//                    sb.append(result+"\n");
//                }
//            }else {
//                sb.append(key + " " + values.get(0)+"\n");
//            }
//        }
//
//        bw.write(sb.toString());
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//}


// 더 효율적인 방법 Comparable<Object>


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        Point[] points = new Point[N];
        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            points[i] = new Point(x,y);
        }
        Arrays.sort(points);
        for(Point point : points) {
            System.out.println(point.toString());
        }
    }

    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            int result = this.x - o.x;
            if(result == 0) {
                result = this.y - o.y;
            }
            return result;
        }

        @Override
        public String toString() {
            return x + " " + y;

        }
    }
}