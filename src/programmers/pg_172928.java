package programmers;

import java.util.*;

class pg_172928 {
    int maxX;
    int maxY;
    char[][] parkBoard;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        maxY = park.length;
        maxX = park[0].length();
        parkBoard = new char[maxX][maxY];

        for(int i = 0;i<maxY;i++) {
            String p = park[i];
            for(int j =0;j<maxX;j++) {
                parkBoard[j][i] = p.charAt(j);
                if(parkBoard[j][i] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for(String route : routes) {
            String[] str = route.split(" ");
            String direct = str[0];
            int move = Integer.parseInt(str[1]);

            System.out.println(answer[0] + " " + answer[1]);

            int[] movedPosition = moving(answer, direct, move);
            answer[0] = movedPosition[0];
            answer[1] = movedPosition[1];
        }

        return answer;
    }

    private boolean check(int[] c) {
        return parkBoard[c[1]][c[0]] == 'X';
    }

    private int[] moving(int[] position, String direct, int move) {
        int[] movedPosition = new int[]{position[0], position[1]};

        if(direct.equals("N")) {
            for(int i =0;i<move;i++) {
                movedPosition[0] -= 1;
                if(movedPosition[0] < 0) {
                    return position;
                }

                if(check(movedPosition)) {
                    return position;
                }
            }

        } else if(direct.equals("S")) {
            for(int i =0;i<move;i++) {
                movedPosition[0] += 1;
                if(movedPosition[0] >= maxX) {
                    return position;
                }

                if(check(movedPosition)) {
                    return position;
                }
            }

        } else if(direct.equals("W")) {
            for(int i =0;i<move;i++) {
                movedPosition[1] -= 1;
                if(movedPosition[1] <0) {
                    return position;
                }

                if(check(movedPosition)) {
                    return position;
                }
            }

        } else {
            for(int i =0;i<move;i++) {
                movedPosition[1] += 1;
                if(movedPosition[1] >= maxX) {
                    return position;
                }

                if(check(movedPosition)) {
                    return position;
                }
            }
        }

        return movedPosition;
    }

    class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override public boolean equals(Object o){
            if (!(o instanceof Dot))
                return false;
            Dot d = (Dot) o;
            return (d.x == this.x && d.y == this.y);
        }
    }
}