import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame
{
    public static void main(String[] args) {
        Scanner choose = new Scanner(System.in);
        System.out.println("Please type the name of which game you want to play");
        System.out.println("Type Guessinggame if you want to guess my number, and type Computerguess if you want me to guess your number!");
        String whichone = choose.nextLine();
        while (!whichone.equals("Guessinggame") && !whichone.equals("Computerguess"))
        {
            System.out.println("I don't think I have that one on my system");
            whichone = choose.nextLine();
        }
        if (whichone.equals("Guessinggame"))
        {
            int guessnum = 0;
            int answer = (int) (Math.random() * 100);
            Scanner input = new Scanner(System.in);
            System.out.println("Please type in the number I am thinking of");
            int guess = 101;
            while (guess != answer) {
                try
                {
                    if (guess > answer) {
                        System.out.println("It's too high! Try going lower");
                        guess = input.nextInt();
                        guessnum++;
                    }
                    if (guess < answer) {
                        System.out.println("It's too low! Try going higher");
                        guess = input.nextInt();
                        guessnum++;
                    }
                    if (guess == answer) {
                        guessnum++;
                        String winstatement = "You did it! It took" + " " + guessnum + " " + "tries!";
                        System.out.println(winstatement);
                    }
                }
                catch(InputMismatchException e)
                {
                    System.out.println("I'm sorry but that's not a number, please try again");
                    input.next();
                }
            }
        }
        if(whichone.equals("Computerguess")) {
            Scanner amIright = new Scanner(System.in);
            System.out.println("Okay, I want you to think of a number between 1 and 100");
            System.out.println("Please type 'higher' if you number is greater than my guess. Please type 'lower' if your number is less than my guess. Type correct if I'm on the spot!");
            int AIguess = 50;
            int highest = 100;
            int lowest = 0;
            String computermess = "Is your number " + AIguess + "?";
            System.out.println(computermess);
            String yoursay = amIright.nextLine();
            while (!yoursay.equals("correct")) {
                if (yoursay.equals("higher")) {
                    lowest = AIguess;
                    AIguess = AIguess + (highest - lowest) / 2;
                    computermess = "Is your number " + AIguess + "?";
                    System.out.println(computermess);
                    yoursay = amIright.nextLine();
                }
                if (yoursay.equals("lower")) {
                    highest = AIguess;
                    AIguess = AIguess - (highest - lowest) / 2;
                    computermess = "Is your number " + AIguess + "?";
                    System.out.println(computermess);
                    yoursay = amIright.nextLine();
                }
            }
            System.out.println("Sweet! I'm a genius huh?");
        }
    }
}
