import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static Random random;

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        random = new Random();

        playGuessNumbers();
        playGuessWords();

        scan.close();

    }

    public static void playGuessNumbers(){

        int userAnswer;
        int secretNumber;

        do {
            System.out.println("Welcome to \"Guess the number\" game");

            secretNumber = random.nextInt(10);
            guessNumber(secretNumber);

            do {
                System.out.println("Do you want to repeat this game? 1-yes, 0-no");
                userAnswer = scan.nextInt();
                if (userAnswer == 0)
                    return;
                else if (userAnswer == 1)
                    break;
                else
                    System.out.println("Unknown command");
            } while (true);

        } while(true);

    }

    public static void guessNumber(int number){

        int userNumber;
        int countAttempts = 3;

        do {
            System.out.println("Please, input the guess number");
            userNumber = scan.nextInt();
            if (number == userNumber) {
                System.out.printf("You win, the guess number is %s\n", number);
                break;
            } else {
                countAttempts--;
                if (countAttempts == 0) {
                    System.out.printf("You lose, the guess number is %s\n", number);
                    break;
                }
                else if (number > userNumber)
                    System.out.printf("The input number is greater, %s attempts left\n", countAttempts);
                else
                    System.out.printf("The input number is less, %s attempts left\n", countAttempts);
            }

        } while (true);

    }

    public static void playGuessWords(){

        int minLength;
        String secretWord;
        String word;
        char[] result   = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        String[] words  = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot"
                , "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive"
                , "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


        System.out.println("Welcome to \"Guess the word\" game");
        secretWord = words[random.nextInt(words.length-1)];

        do {
            System.out.println("Please, input the guess word");

            word = scan.nextLine().toLowerCase();
            if (secretWord.equals(word)){
                System.out.printf("You win, the guess word is %s\n", secretWord);
                break;
            } else {
                minLength = Math.min(word.length(),secretWord.length());
                for (int i = 0; i < minLength; i++) {
                    if (word.charAt(i) == secretWord.charAt(i))
                        result[i] = word.charAt(i);
                }
                System.out.print("The word is wrong ");
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }

        } while (true);

    }


}
