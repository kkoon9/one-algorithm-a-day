package baekjoon._5000._5397;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loopNum = Integer.parseInt(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < loopNum; i++) {
            String s = br.readLine();
            String[] inputStringArr = s.split("");

            List<String> answer = new ArrayList<>();
            Integer index = 0;

            for (String string : inputStringArr) {
                if(!string.equals("<")&&!string.equals(">")&&!string.equals("-")) {
                    answer.add(index,string);
                    index++;
                }

                if (string.equals("<") && index >= 1) {
                    index--;
                }

                if (string.equals(">") && !(index == answer.size())) {
                    index++;
                }

                if (string.equals("-") && !(index==0)) {
                    answer.remove(index - 1);
                    index--;
                }
            }


            for (String s1 : answer) {
                stringBuilder.append(s1);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}

// stack 사용
//import java.util.*;
//    import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int T = Integer.valueOf(st.nextToken());
//        for (int t = 0; t < T; t++) {
//            String input = br.readLine();
//
//            String answer = solution(input);
//            System.out.println(answer);
//        }
//
//
//    }
//
//    private static String solution(String password) {
//        String[] words = password.split("");
//        Stack<String> leftStack = new Stack<>();
//        Stack<String> rightStack = new Stack<>();
//
//        for(String word : words) {
//            if(word.equals(">")) {
//                if(!rightStack.isEmpty()) {
//                    leftStack.push(rightStack.pop());
//                }
//            } else if(word.equals("<")) {
//                if(!leftStack.isEmpty()) {
//                    rightStack.push(leftStack.pop());
//                }
//            } else if(word.equals("-")) {
//                if(!leftStack.isEmpty()) {
//                    leftStack.pop();
//                }
//            } else {
//                leftStack.push(word);
//            }
//        }
//        StringBuilder leftSb = new StringBuilder();
//        StringBuilder rightSb = new StringBuilder();
//        while(!leftStack.empty()) {
//            leftSb.append(leftStack.pop());
//        }
//        while(!rightStack.empty()) {
//            rightSb.append(rightStack.pop());
//        }
//
//        String answer = leftSb.reverse().toString() + rightSb.toString();
//
//        return answer;
//    }
//}