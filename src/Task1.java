import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : words1) {
            map1.putIfAbsent(word, 0);
            map1.put(word, map1.get(word) + 1);
        }

        for (String word : words2) {
            map2.putIfAbsent(word, 0);
            map2.put(word, map2.get(word) + 1);
        }

        int count = 0;
        for (String word : words1) {
            if (map1.containsKey(word) && map1.get(word) == 1
                    && map2.containsKey(word) && map2.get(word) == 1) {
                count++;
            }
        }

        return count;
    }
}
