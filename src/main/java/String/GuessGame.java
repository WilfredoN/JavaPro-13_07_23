package String;


import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {
    public record GuessResult(boolean result, String hint) {
    }

    private static int hintCounter = 0;

    public static GuessResult guessWordProcessing(String answer, String wordToGuess, StringBuilder hint) {
        if (Arrays.equals(answer.toCharArray(), wordToGuess.toCharArray())) {
            System.out.println("Ви вгадали слово " + wordToGuess + "!");
            return new GuessResult(true, "");
        }
        if (hintCounter < wordToGuess.length()) {
            hint.append(wordToGuess.charAt(hintCounter));
            hintCounter++;
        }
        System.out.println(hint);
        return new GuessResult(false, hint.toString());
    }

    public static String main(int index) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordToGuess = words[index];
        System.out.println("Слово загадане!");
        Scanner sc = new Scanner(System.in);
        StringBuilder hint = new StringBuilder();
        while (true) {
            System.out.print("Вгадайте слово: ");
            String answer = sc.nextLine();
            GuessResult result = guessWordProcessing(answer, wordToGuess, hint);
            if (result.result()) break;
        }
        return wordToGuess;
    }
}
