package string;

public class Strings {
    public static int findSymbolOccurance(String source, char target) {
        int numberOfEnter = 0;
        char[] sourceElements = source.toLowerCase().toCharArray();
        for (int i = 0; i < source.length(); i++) {
            if (sourceElements[i] == target) numberOfEnter++;
        }
        return numberOfEnter;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String source) {
        char[] temp = source.toCharArray();
        String result = "";
        for (int i = temp.length - 1; i >= 0; i--) result = result + temp[i];
        return result;
    }

    public static boolean isPalindrome(String source) {
        return source.equalsIgnoreCase(stringReverse(source));
    }
}