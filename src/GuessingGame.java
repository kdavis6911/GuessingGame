import java.util.Scanner;

public class GuessingGame
{
    public static void main(String[] args) {
        Scanner choose = new Scanner(System.in);
        System.out.println("Please type the name of which game you want to play");
        System.out.println("Type GuessingGame if you want to guess my number, and type ComputerGuess if you want me to guess your number!");
        String whichone = choose.nextLine();
        if (whichone.equals("GuessingGame"))
        {
            int guessnum = 0;
            int answer = (int) (Math.random() * 100);
            Scanner input = new Scanner(System.in);
            System.out.println("Please type in the number I am thinking of");
            int guess = input.nextInt();
            while (guess != answer) {
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
            }
            if (guess == answer) {
                guessnum++;
                String winstatement = "You did it! It took" + " " + guessnum + " " + "tries!";
                System.out.println(winstatement);
            }
        }
        if(whichone.equals("ComputerGuess"))
        {
            Scanner amIright = new Scanner(System.in);
            System.out.println("Okay, I want you to think of a number between 1 and 100");
            System.out.println("");
            int AIguess = 50;
            int highest = 100;
            int lowest = 0;
            String computermess = "Is your number " + AIguess + "?";
            System.out.println(computermess);
            String yoursay = amIright.nextLine();
            while (!yoursay.equals("correct"))
            {
                if (yoursay.equals("higher"))
                {
                    lowest = AIguess;
                    AIguess = AIguess + (highest - lowest)/2;
                    computermess = "Is your number " + AIguess + "?";
                    System.out.println(computermess);
                    yoursay = amIright.nextLine();
                }
                if (yoursay.equals("lower"))
                {
                    highest = AIguess;
                    AIguess = AIguess - (highest - lowest)/2;
                    computermess = "Is your number " + AIguess + "?";
                    System.out.println(computermess);
                    yoursay = amIright.nextLine();
                }
            }
            System.out.println("Sweet! I'm a genius huh?");
        }
    }
}
