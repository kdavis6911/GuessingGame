import java.util.Scanner;

public class GuessingGame
{
    public static void main(String[] args)
    {
        int answer = (int)(Math.random() * 100);
        Scanner input = new Scanner(System.in);
        System.out.println("Please guess a number");
        int guess = input.nextInt();
        while (guess != answer) {
            if (guess > answer) {
                System.out.println("It's too high! Try going lower");
                guess = input.nextInt();
            }
            if (guess < answer) {
                System.out.println("It's too low! Try going higher");
                guess = input.nextInt();
            }
            if (guess == answer) {
                System.out.println("You did it!");
            }
        }
    }
}
