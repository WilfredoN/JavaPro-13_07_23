package String;


public class Main {
     public static void main(String []args) {
        System.out.println("1)\nSource - Batman\nTarget - a\nResult - " + Strings.findSymbolOccurance("Batman",'a'));
        System.out.println("2)\nSource - Apollo\nTarget - pollo\nResult - " + Strings.findWordPosition("Apollo", "pollo"));
        System.out.println("3)\nSource - World\nTarget - dlroW\nResult - " + Strings.stringReverse("World"));
        System.out.println("4)\nSource - Ollo\nTarget - true\nResult - " + Strings.isPalindrome("Ollo"));
        System.out.println(GuessGame.guessWordInput(1));
     }
}