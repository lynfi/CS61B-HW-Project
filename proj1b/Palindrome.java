public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        // return the char deque;
        Deque<Character> a = new ArrayDeque();
        for (int i = 0; i < word.length(); i++) {
            a.addLast(word.charAt(i));
        }
        return a;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> a = wordToDeque(word);
        while (a.size() > 1) {
            char first = a.removeFirst();
            char last = a.removeLast();
            if (first != last)
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> a = wordToDeque(word);
        while (a.size() > 1) {
            char first = a.removeFirst();
            char last = a.removeLast();
            if (!cc.equalChars(first, last))
                return false;
        }
        return true;
    }

}
