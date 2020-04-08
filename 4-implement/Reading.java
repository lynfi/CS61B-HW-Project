import java.util.*;

public class Reading {
    public static List<String> getWords(String inputFileName) {
        In in = new In(inputFileName);
        List<String> l = new ArrayList<String>();
        while (!in.isEmpty()) {
            l.add(in.readString());
        }
        return l;
    }

    public static int conutUniqueWords(List<String> l) {
        Set<String> ss = new HashSet<>();
        for (String s : l) {
            ss.add(s);
        }
        return ss.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> target, List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String t : target) {
            counts.put(t, 0);
        }
        for (String s : words) {
            if (counts.containsKey((s))) {
                counts.put(s, counts.get(s) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(conutUniqueWords(getWords("test.txt")));
    }
}

