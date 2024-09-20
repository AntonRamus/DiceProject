package opgave03;

import java.util.Scanner;

public class Pigs {

    //variabler der holder pointene for spillerne
    private static int[] playerPoints = new int[2];
    private static int playerTurn = 0;

    public static void main(String[] args) {
        //introduktion og regler bliver printet ud
        System.out.println("Welcome to pigs!");
        printRules();

        //starter spillet
        playPigs();

    }
    //metode til at udskrive regler for spillet (bliver kaldt i main på linje 13)
    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for pigs");
        System.out.println("Two players take turns rolling a die.");
        System.out.println("The player may roll as many times as they wish.");
        System.out.println("The sum of these rolls are added to your total point score when you end your turn.");
        System.out.println("If the die at any time shows a 1, the round ends and the player gets no points.");
        System.out.println("A player wins when they reach 100 points.");
        System.out.println("=====================================================");
    }

    // playPigs er den primære metode hvor spillet forgår
    private static void playPigs() {
        while (playerPoints[0] < 100 || playerPoints[1] < 100) { //så længe playerPoints[0] eller playerpoints[1] er mindre end 100 forsætter spillet
            // player 1 tur
            if (playerTurn == 0) {
                System.out.println("It's player 1's turn.");
                oneRound(0);
                if (playerPoints[0] > 99) {
                    System.out.println("Player 1 wins with " + playerPoints[0] + " points.");
                    return;
                }
                playerTurn++; //skifter spiller
            } else {
                //player 2 tur
                System.out.println("It's player 2's turn.");
                oneRound(1);
                if (playerPoints[1] > 99) {
                    System.out.println("Player 2 wins with " + playerPoints[1] + " points.");
                    return;
                }
                playerTurn--; //skifter spiller
            }
        }
    }
    //metode der starter et spil pigs
    private static void oneRound(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        int temporaryPointScore = 0;
        System.out.println("Press enter to start your turn.");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) { //så længe svaret ikke er nej (!answer) forsætte spillet
             /*metode kald. Resultatet af rollDice bliver gemt i en ny variable
            af typen integer array ved navn diceRoll
             */
            int diceRoll = rollDice();
            if (diceRoll == 1) { // hvis man ruller 1 så slutter spillerns tur
                System.out.println("You rolled a 1. Your turn has ended and you get no points.");
                System.out.println();
                return;
            }
            // integer variable temporaryPointScore holder pointene for den nuværende runde
            temporaryPointScore += diceRoll;
            System.out.println("You rolled " + diceRoll + " and your points this round are " + temporaryPointScore);
            System.out.print("Do you wish to roll again? (yes/no)");
            answer = scanner.nextLine();
        }
        // uddelegere pointene til den enkelte spiller
        playerPoints[playerNumber] += temporaryPointScore;
        System.out.println();
        System.out.println(temporaryPointScore + " points have been added to your total.");
        System.out.println("player " + (playerNumber + 1) + " now has " + playerPoints[playerNumber] + " points.");
        System.out.println();
        return;
    }

    //metode til at rulle en terning med 6 øjne
    private static int rollDice() {
        return (int)(Math.random() * 6 + 1);
    }
}
