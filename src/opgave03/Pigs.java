package opgave03;

import java.util.Scanner;

public class Pigs {
    static Scanner scanner = new Scanner(System.in);
    //variabler der holder pointene for spillerne
    private static int[] playerPoints = new int[2];
    private static int playerTurn = 0;
    private static int [] rolls = new int[2];
    private static int [] turns = new int[2];

    public static void main(String[] args) {
        //introduktion og regler bliver printet ud
        System.out.println("Welcome to pigs!");
        printRules();

        //starter spillet
        playPigs();

        System.out.println();
        averageRolls();
    }
    //metode til at udskrive regler for spillet
    private static void printRules() {
        System.out.println("=================================================================================");
        System.out.println("Rules for pigs");
        System.out.println("Two players take turns rolling two dice.");
        System.out.println("The player may roll as many times as they wish.");
        System.out.println("The sum of these rolls are added to your total point score when you end your turn.");
        System.out.println("If a die at any time shows a 1, the round ends and the player gets no points.");
        System.out.println("If both dice show 1, the round ends and the player loses all points.");
        System.out.println("The player decides for how many points to play for.");
        System.out.println("=================================================================================");
    }

    // playPigs er den primære metode hvor spillet forgår
    private static void playPigs() {

        System.out.print("how many points do you want to play for: " );
        int pointsToWin = scanner.nextInt();
        scanner.nextLine(); // sluger enter så scannneren forsat kan bruges

        while (playerPoints[0] < pointsToWin || playerPoints[1] < pointsToWin) { //så længe playerPoints[0] eller playerpoints[1] er mindre end pointsToWin forsætter spillet
            // player 1 tur
            if (playerTurn == 0) {
                System.out.println("*** It's player 1's turn. ***");
                oneRound(0);
                turns[0]++;
                if (playerPoints[0] >= pointsToWin) {
                    System.out.println("Player 1 wins with " + playerPoints[0] + " points.");
                    return;
                }
                playerTurn++; //skifter spiller
            } else {
                //player 2 tur
                System.out.println("*** It's player 2's turn. ***");
                oneRound(1);
                turns[1]++;
                if (playerPoints[1] >= pointsToWin) {
                    System.out.println("Player 2 wins with " + playerPoints[1] + " points.");

                    return;
                }
                playerTurn--; //skifter spiller
            }
        }
    }
    //metode der starter et spil pigs
    private static void oneRound(int playerNumber) {
        int temporaryPointScore = 0;
        System.out.println("Current point score: " + playerPoints[playerNumber]); //viser hvor mange point spilleren har
        System.out.print("Press Enter to start your turn.");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) { //så længe svaret ikke er nej (!answer) forsætter spillet
             /*metode kald. Resultatet af rollDice bliver gemt i en ny variable
            af typen integer array ved navn diceRoll
             */
            int[] diceRoll = rollDice();
            rolls[playerNumber]++;

            if (diceRoll[0] == 1 && diceRoll[1] == 1) { // hvis man ruller to 1'ere så slutter spillerns tur og man mister alle point
                playerPoints[playerNumber] = 0;
                System.out.println("You rolled two 1s. Your turn has ended and you lose all points.");
                System.out.println();

                return;
            }

            if (diceRoll[0] == 1 || diceRoll[1] == 1) { // hvis man ruller 1 så slutter spillerns tur
                System.out.println("You rolled a " + diceRoll[0] + " and a " + diceRoll[1] + ". Your turn has ended and you get no points.");
                System.out.println();

                return;
            }
            // integer variable temporaryPointScore holder pointene for den nuværende runde
            temporaryPointScore += diceRoll[0] + diceRoll[1];
            System.out.println("You rolled " + diceRoll[0] + " and " + diceRoll[1] + ". Your points this round are " + temporaryPointScore);
            System.out.print("Do you wish to roll again? (yes/no) ");
            answer = scanner.nextLine();
        }
        // uddelegere pointene til den enkelte spiller
        playerPoints[playerNumber] += temporaryPointScore;
        System.out.println();
        System.out.println(temporaryPointScore + " points have been added to your total.");
        System.out.println("Player " + (playerNumber + 1) + " now has " + playerPoints[playerNumber] + " points.");
        System.out.println();
        return;
    }

    //metode der beregne gennemsnitlige antal rul og udskriver det
    private static void averageRolls() {
        double[] rollsPerTurn = new double[2]; // array til holde rul for hver runde

        // for løkke der beregner gennemsnit af, hvor mange kast de to spillere i gennemsnit laver i hver tur
        for (int index = 0; index < rollsPerTurn.length; index++) {
            rollsPerTurn[index] = (double) rolls[index] / turns[index];

            //udskriver gennemsnitet af antal rul
            System.out.println("Player " + (index + 1) + " rolled " + rollsPerTurn[index] + " times per turn.");
        }
    }

    //metode til at rulle to terninger med 6 øjne
    private static int[] rollDice() {
        int[] faces = new int[2];

        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);

        return faces;
    }
}
