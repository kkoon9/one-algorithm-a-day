package baekjoon._1000._1931_greedy;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        int N = Integer.parseInt(br.readLine());
        Time[] times = new Time[N];
        for(int i = 0 ;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        Arrays.sort(times);
        int now = times[0].end;
        for(int i = 1 ; i <N;i++) {
            if(times[i].start < now) {
                continue;
            }
            answer++;
            now = times[i].end;
        }

        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(@NotNull Time o) {
            int result = this.end - o.end;
            if(result == 0) {
                result = this.start - o.start;
            }
            return result;
        }
    }
}
