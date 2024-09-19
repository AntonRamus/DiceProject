package opgave01;

import java.util.Scanner;
public class RollTwoDice {

    private static int rollCount = 0;
    private static int[] rollStatistics = new int[6];
    private static int sumOfDiceRolls = 0;
    private static int sameFaceRolls = 0;
    private static int largestRoll = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game roll two dice.");
        printRules();
        System.out.println();

        playTwoDie();

        System.out.println();
        System.out.println("Thank you for playing roll two dice.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for roll two dice");
        System.out.println("The player rolls two dice as long as they want.");
        System.out.println("=====================================================");
    }

    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll the dice? ('yes/no') ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] face = rollTwoDice();
            System.out.println("You rolled: " + face[0] + " with the first die, and " + face[1] + " with the second die.");
            System.out.println();

            updateStatistics(face);

            System.out.print("Roll the dice? ('yes/no') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int [] rollTwoDice() {
        int[] faces = new int[2];

        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);

        return faces;
    }

    private static void updateStatistics(int[] faces) {
        sumOfDiceRolls += faces[0] + faces[1];
        if (faces[0] == faces[1]) {
            sameFaceRolls++;
        }
        if ((faces[0] + faces[1]) > largestRoll) {
            largestRoll = (faces[0] + faces[1]);
        }
        rollStatistics[faces[0] - 1]++;
        rollStatistics[faces[1] - 1]++;
        rollCount++;
    }


    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Sum of dice rolls: ", sumOfDiceRolls);
        if (sameFaceRolls == 1) {
            System.out.println("The dice rolled the same number " + sameFaceRolls + " time");
        } else {
            System.out.println("The dice rolled the same number " + sameFaceRolls + " times");
        }
        System.out.println("The largest roll was: " + largestRoll);
        System.out.println();
        for (int index = 0; index < 6; index++) {
            System.out.print("You rolled " + (index + 1) + ": ");
            if (rollStatistics[index] == 1) {
                System.out.println(rollStatistics[index] + " time");
            } else {
                System.out.println(rollStatistics[index] + " times");
            }
        }
        System.out.println();
        System.out.printf("%17s %6d\n", "Amount of  rolls:", rollCount);
    }

}
