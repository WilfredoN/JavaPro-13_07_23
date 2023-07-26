package String;

import java.util.Arrays;
import java.util.Scanner;

public class Strings {
     public static int findSymbolOccurance(String source, char target) {
        int numberOfEnter = 0;
        char[] sourceElements = source.toLowerCase().toCharArray();
        for(int i = 0; i < source.length(); i++) {
            if (sourceElements[i] == target) numberOfEnter++;
        }
        return numberOfEnter;
    }
     public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }
    public static StringBuilder stringReverse(String source) {
         char[] temp = source.toCharArray();
         StringBuilder result = new StringBuilder();
         for(int i = temp.length - 1; i >= 0; i--) result.append(temp[i]);
         return result;
     }
    public static boolean isPalindrome(String source) {
         source = source.toLowerCase();
         for (int i = 0; i < (source.length() / 2); i++) {
             if (source.charAt(i) != source.charAt(source.length() - i - 1)) {
                 return false;
             }
         }
         return true;
    }
    public static boolean guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordToGuess = words[(int) (Math.random() * words.length)];
        char[] guessedWordHash = wordToGuess.toCharArray();
        Arrays.fill(guessedWordHash, '#');
        Scanner sc = new Scanner(System.in);
        System.out.println("Слово загадане! \n" + Arrays.toString(guessedWordHash) + "\n" + Arrays.toString(wordToGuess.toCharArray()));
        while (true) {
            System.out.print("Вгадайте слово: ");
            String answer = sc.nextLine();
            if (Arrays.equals(answer.toCharArray(), wordToGuess.toCharArray())) {
                System.out.println("Ви вгадали слово!");
                break;
            }
                for (int i = 0; i < guessedWordHash.length - 1; i++)
                    if (answer.charAt(i) == Arrays.toString(wordToGuess.toCharArray()).charAt(i))
                        guessedWordHash[i] = answer.charAt(i);
                System.out.println(guessedWordHash);
        }
        return true;
    }
}
