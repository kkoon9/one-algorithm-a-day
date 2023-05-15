package programmers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class pg_178871 {
    public static void main(String[] args) {
        String[] players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = new String[]{"kai", "kai", "mine", "mine"};
        String[] result = solution(players, callings);
        for(String r : result) {
            System.out.println(r);
        }
    }
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Player> playerMap = new HashMap<>();
        playerMap.put(players[0], new Player(1, players[0], null, players[1]));
        for (int i = 1; i < players.length - 1; i++) {
            playerMap.put(players[i], new Player(i + 1, players[i], players[i - 1], players[i + 1]));
        }
        playerMap.put(players[players.length - 1], new Player(players.length, players[players.length - 1], players[players.length - 2], null));


        for (String calling : callings) {
            Player nowPlayer = playerMap.get(calling);
            String beforePlayerName = nowPlayer.beforeName;
            String nextPlayerName = nowPlayer.nextName;
            int nowPlayerRank = nowPlayer.rank;
            Player nextPlayer = playerMap.get(nextPlayerName);

            // 호명된 선수 정보 변경
            nowPlayer.setRank(nowPlayerRank - 1);
            nowPlayer.setBeforeName(nextPlayerName);
            nowPlayer.setNextName(nextPlayer.nextName);
            playerMap.put(nowPlayer.name, nowPlayer);

            // 제쳐진 선수의 다음 선수 변경
            Player nextPlayerOfNextPlayer = playerMap.get(nextPlayer.nextName);
            nextPlayerOfNextPlayer.setBeforeName(calling);
            playerMap.put(nextPlayerOfNextPlayer.name, nextPlayerOfNextPlayer);

            // 제쳐진 선수 정보 변경
            nextPlayer.setRank(nowPlayerRank);
            nextPlayer.setNextName(calling);
            nextPlayer.setBeforeName(beforePlayerName);
            playerMap.put(nextPlayer.name, nextPlayer);

            // 호명된 선수의 이전 선수 변경
            if(beforePlayerName == null) {
                continue;
            }
            Player beforePlayer = playerMap.get(beforePlayerName);
            beforePlayer.setNextName(nextPlayerName);
            playerMap.put(beforePlayer.name, beforePlayer);
        }

        List<Player> playerList = new ArrayList<>();
        for (String key : playerMap.keySet()) {
            playerList.add(playerMap.get(key));
        }

        Collections.sort(playerList);

        for (int i = 0; i < players.length; i++) {
            answer[i] = playerList.get(i).name;
        }

        return answer;
    }

    static class Player implements Comparable<Player> {
        private int rank;
        private String name;
        private String nextName;
        private String beforeName;

        public Player(int rank, String name, String nextName, String beforeName) {
            this.name = name;
            this.rank = rank;
            this.nextName = nextName;
            this.beforeName = beforeName;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public void setNextName(String nextName) {
            this.nextName = nextName;
        }

        public void setBeforeName(String beforeName) {
            this.beforeName = beforeName;
        }

        @Override
        public int compareTo(@NotNull Player o) {
            return this.rank - o.rank;
        }
    }
}
