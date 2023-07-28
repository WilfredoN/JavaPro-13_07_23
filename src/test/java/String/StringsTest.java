package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    @Test
    void shouldFindOneMoreSymbolEntrance() {
        int result = Strings.findSymbolOccurance("Batman", 'a');
        assertEquals(2, result);
    }
    @Test
    void shouldFindNoSymbolEntrance() {
        int result = Strings.findSymbolOccurance("Batman", 's');
        assertEquals(0, result);
    }
    @Test
    void shouldFindWordPosition() {
        int result = Strings.findWordPosition("Apollo", "pollo");
        assertEquals(1, result);
    }
    @Test
    void shouldNoFindWordPosition() {
        int result = Strings.findWordPosition("Apollo", "hillel");
        assertEquals(-1, result);
    }
    @Test
    void shouldReverseString() {
        String result = String.valueOf(Strings.stringReverse("World"));
        assertEquals("dlroW", result);
    }
    @Test
    void shouldConfirmIsPalindrome() {
        boolean result = Strings.isPalindrome("Ollo");
        assertTrue(result);
    }
    @Test
    void shouldNoConfirmIsPalindrome() {
        boolean result = Strings.isPalindrome("Allo");
        assertFalse(result);
    }
    @Test
    void shouldToGuessTheWord() {
        //args String answer, char[] guessedWordHash, String wordToGuess
      String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
      String wordToGuess = words[1];
      StringBuilder hint = new StringBuilder();
      assertFalse(GuessGame.guessWordProcessing("apple", wordToGuess, hint).result());
      assertFalse(GuessGame.guessWordProcessing("lemon", wordToGuess, hint).result());
      assertFalse(GuessGame.guessWordProcessing("avocado", wordToGuess, hint).result());
      assertTrue(GuessGame.guessWordProcessing("orange", wordToGuess, hint).result());
    }
}