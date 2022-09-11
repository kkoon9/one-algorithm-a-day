package baekjoon._12000._12891_slidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        Long answer = 0L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] dnaCounts = new int[4];
        int[] passwordDnaCounts = new int[4];
        for (int i = 0; i < 4; i++) {
            // A, C, G, T
            dnaCounts[i] = Integer.parseInt(st.nextToken());
        }

        // init
        int lastIndex = M;
        for (int i = 0; i < lastIndex; i++) {
            add(str.charAt(i), passwordDnaCounts);
        }
        if (check(dnaCounts, passwordDnaCounts)) {
            answer++;
        }

        for (int i = 0; i < N; i++) {
            lastIndex++;
            if (lastIndex > N) break;

            minus(str.charAt(i), passwordDnaCounts);
            add(str.charAt(lastIndex - 1), passwordDnaCounts);
            if (check(dnaCounts, passwordDnaCounts)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void minus(char ch, int[] passwordDnaCounts) {
        int minusIndex = getIndexByPasswordChar(ch);
        if (minusIndex != -1) {
            passwordDnaCounts[minusIndex]--;
        }
    }

    private static void add(char ch, int[] passwordDnaCounts) {
        int index = getIndexByPasswordChar(ch);
        if (index == -1) return;
        passwordDnaCounts[index]++;
    }

    private static boolean check(int[] dnaCounts, int[] passwordDnaCounts) {
        for (int i = 0; i < 4; i++) {
            if (dnaCounts[i] > passwordDnaCounts[i]) {
                return false;
            }
        }
        return true;
    }

    private static int getIndexByPasswordChar(char ch) {
        int index = -1;
        switch (ch) {
            case 'A':
                index = 0;
                break;
            case 'C':
                index = 1;
                break;
            case 'G':
                index = 2;
                break;
            case 'T':
                index = 3;
                break;
        }

        return index;
    }
}
