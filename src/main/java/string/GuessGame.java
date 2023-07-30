package string;


import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {
    public record GuessResult(boolean result, String hint) {
    }
    public static char[] hint = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
    public static GuessResult guessWordProcessing(String answer, String wordToGuess) {
        if (Arrays.equals(answer.toCharArray(), wordToGuess.toCharArray())) {
            System.out.println("Ви вгадали слово " + wordToGuess + "!");
            return new GuessResult(true, "");
        }
            for (int i = 0; i < answer.length() && i < wordToGuess.length(); i++) {
                if (answer.toCharArray()[i] == wordToGuess.toCharArray()[i]) {
                    hint[i] = (wordToGuess.charAt(i));
                }
            }
            System.out.println(hint);
            return new GuessResult(false, Arrays.toString(hint));

    }

    public static String main(int index) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordToGuess = words[index];
        System.out.println("Слово загадане!");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Вгадайте слово: ");
            String answer = sc.nextLine();
            GuessResult result = guessWordProcessing(answer, wordToGuess);
            if (result.result()) break;
        }
        return wordToGuess;
    }
}
