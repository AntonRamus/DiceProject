package opgave03;

import java.util.Scanner;

public class Pigs {

    private static int[] playerPoints = new int[2];
    private static int playerTurn = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to pigs!");
        printRules();

        playPigs();

    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for pigs");
        System.out.println("Two players take turns rolling a die.");
        System.out.println("The player may roll as many times as they wish.");
        System.out.println("The sum of these rolls are added to your total point score when you end your turn.");
        System.out.println("If the die at any time shows a 1, the round ends and the player gets no points.");
        System.out.println("=====================================================");
    }

    private static void playPigs() {
        while (playerPoints[0] < 100 || playerPoints[1] < 100) {
            if (playerTurn == 0) {
                System.out.println("It's player 1's turn.");
                oneRound(0);
                if (playerPoints[0] > 99) {
                    System.out.println("Player 1 wins with " + playerPoints[0] + "points.");
                    return;
                }
                playerTurn++;
            } else {
                System.out.println("It's player 2's turn.");
                oneRound(1);
                if (playerPoints[1] > 99) {
                    System.out.println("Player 2 wins with " + playerPoints[1] + "points.");
                    return;
                }
                playerTurn--;
            }
        }
    }

    private static void oneRound(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        int temporaryPointScore = 0;
        System.out.println("Press enter to start your turn.");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int diceRoll = rollDice();
            if (diceRoll == 1) {
                System.out.println("You rolled a 1. Your turn has ended and you get no points.");
                System.out.println();
                return;
            }
            temporaryPointScore += diceRoll;
            System.out.println("You rolled " + diceRoll + " and your points this round are " + temporaryPointScore);
            System.out.print("Do you wish to roll again? (yes/no)");
            answer = scanner.nextLine();
        }
        playerPoints[playerNumber] += temporaryPointScore;
        System.out.println();
        System.out.println(temporaryPointScore + " points have been added to your total.");
        System.out.println("player " + (playerNumber + 1) + " now has " + playerPoints[playerNumber] + " points.");
        System.out.println();
        return;
    }


    private static int rollDice() {
        return (int)(Math.random() * 6 + 1);
    }
}
