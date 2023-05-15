package programmers;

import java.util.HashMap;
import java.util.Map;

class pg_176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> yearnings = new HashMap<>();
        for (int i = 0; i < yearning.length; i++) {
            yearnings.put(name[i], yearning[i]);
        }

        for(int i = 0;i<photo.length;i++) {
            String[] photos = photo[i];
            for(String p : photos) {
                answer[i] += yearnings.getOrDefault(p, 0);
            }
        }
        return answer;
    }
}
