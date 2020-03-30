import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String a = "a";
        String b = "abcdcba";
        String c = "bbacbb";
        String d = "123454321";
        assertTrue(palindrome.isPalindrome(a));
        assertTrue(palindrome.isPalindrome(b));
        assertFalse(palindrome.isPalindrome(c));
        assertTrue(palindrome.isPalindrome(d));
    }

    @Test
    public void testIsPalindromeGeneralized() {
        String a = "a";
        String b = "abcdcba";
        String c = "flake";
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(a, cc));
        assertFalse(palindrome.isPalindrome(b, cc));
        assertTrue(palindrome.isPalindrome(c, cc));
    }
}

//Uncomment this class once you've created your Palindrome class.