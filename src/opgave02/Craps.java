package opgave02;

import java.util.Scanner;

public class Craps {


    public static void main(String[] args) {
        System.out.println("Welcome to crabs!");
        printRules();

        playCrabs();

        System.out.println("Thank you for playing crabs.");
    }

    private static void playCrabs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Roll the dice? (yes/no): ");
        String answer = scanner.nextLine();

        while (!answer.equals("no")) {

            int diceRoll = rollDice();
            System.out.println("You rolled a: " + diceRoll);

//        if the player wins
            if (diceRoll == 7 || diceRoll == 11) {
                System.out.println("You won!");
            } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) { //If the player loses.
                System.out.println("You lost.");
            } else { //If the player neither wins or loses.
                System.out.println("The game continues with " + diceRoll + " as the point.");

                if(rollForPoint(diceRoll)) {
                    System.out.println("You won the point roll!");
                } else {
                    System.out.println("You lost the point roll.");
                }

            }

            System.out.print("Do you wanna play again? (yes/no): ");
            answer = scanner.nextLine();
            scanner.close();
        }
    }

    private static boolean rollForPoint(int point) {
        int newRoll = rollDice();
        System.out.println("Your roll for point is: " + newRoll);
        while (newRoll != point && newRoll != 7) {
            System.out.println("You keep rolling.");
            newRoll = rollDice();
            System.out.println("Your new roll for point is: " + newRoll);
            }
        if (newRoll == point) {
            return true;
        } else {
            return false;
        }
    }

    private static int rollDice() {
        return (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for crabs");
        System.out.println("The player rolls two dice.");
        System.out.println("If the sum of the dice is 7 or 11, the player wins.");
        System.out.println("If the sum of the dice is 2, 3 or 12, the player loses.");
        System.out.println();
        System.out.println("If the player rolls anything else, this roll becomes the 'point'");
        System.out.println("If the point is rolled, the player wins.");
        System.out.println("If 7 is rolled, the player loses.");
        System.out.println("The player will keep rolling until they win or lose.");
        System.out.println("=====================================================");
    }
}
