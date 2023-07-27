package String;


import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {
    public record GuessResult(boolean result, String hint) { }
    public static GuessResult guessWordProcessing(String answer, String wordToGuess) {
        if (Arrays.equals(answer.toCharArray(), wordToGuess.toCharArray())) {
            System.out.println("Ви вгадали слово!");
        }
        else {
            String hint = "";
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == wordToGuess.toCharArray()[i]) {
                    hint += (answer.charAt(i));
                }
                else {
                    hint += "#";
                }
            }
            for (int i = hint.length(); i < 15; i++) {
                hint += "#";
            }
            System.out.println(hint);
        }
    }

    public static String loopProcessing(String wordToGuess) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Вгадайте слово: ");
            String answer = sc.nextLine();

        }
    }

    public static String guessWordInput(int index) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordToGuess = words[index];   //words[(int) (Math.random() * words.length)];
        //System.out.println("Слово загадане! \n" + Arrays.toString(guessedWordHash) + "\n" + Arrays.toString(wordToGuess.toCharArray()));
        System.out.println("Слово загадане!");

    }
}
// TODO To add correct return statements.
