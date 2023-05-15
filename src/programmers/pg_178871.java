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
        for (String r : result) {
            System.out.println(r);
        }
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranks = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            ranks.put(players[i], i);
        }

        for (String calling : callings) {
            Integer nowPlayerRank = ranks.get(calling);
            String nextPlayer = players[nowPlayerRank-1];

            players[nowPlayerRank-1] = calling;
            players[nowPlayerRank] = nextPlayer;

            ranks.put(calling, nowPlayerRank-1);
            ranks.put(nextPlayer, nowPlayerRank);
        }
        return players;
    }
}
