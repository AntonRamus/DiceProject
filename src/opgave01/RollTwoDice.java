package opgave01;

import java.util.Scanner;
public class RollTwoDice {
    //variabler der holder statistikker for spillet
    private static int rollCount = 0;
    private static int[] rollStatistics = new int[6];
    private static int sumOfDiceRolls = 0;
    private static int sameFaceRolls = 0;
    private static int largestRoll = 0;

    public static void main(String[] args) {
        //introduktion og regler bliver printet ud
        System.out.println("Welcome to the game roll two dice.");
        printRules();
        System.out.println();

        //starter spillet
        playTwoDie();

        System.out.println();
        System.out.println("Thank you for playing roll two dice.");
    }

    //metode til at udskrive regler for spillet
    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for roll two dice");
        System.out.println("The player rolls two dice as long as they want.");
        System.out.println("=====================================================");
    }

    // playTwoDie er den primære metode hvor spillet foregår
    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in); //opretter til scanner til at tag input fra brugeren
        System.out.print("Roll the dice? ('yes/no') ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) { //så længe svaret ikke er nej (!answer) forsætter spillet

            /*metode kald. Resultatet af rollTwodice bliver gemt i et nyt integer array
            ved navn rollTwoDiceResults
             */
            int[] rollTwoDiceResults = rollTwoDice();
            System.out.println("You rolled: " + rollTwoDiceResults[0] + " with the first die, and " + rollTwoDiceResults[1] + " with the second die.");
            System.out.println();

            /*updateStatistics(diceResults) sender resultatet af int[] rollTwoDiceResults
            ned til metoden updateStatistics som beregner diverse statistiker
             */
            updateStatistics(rollTwoDiceResults);

            System.out.print("Roll the dice? ('yes/no') "); //spilleren bliver spurgt om de vil fortsætte med at spille
            answer = scanner.nextLine();
        }

        printStatistics(); //udskriver statistiker efter spillet stoppes
        scanner.close();
    }

    //metode til at rulle to terninger og retunere resultatet som int[]
    private static int [] rollTwoDice() {
        int[] faces = new int[2];

        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);

        return faces;
    }

    //metode der beregner statistiker der printes ved spillets slut
    private static void updateStatistics(int[] faces) {
        sumOfDiceRolls += faces[0] + faces[1]; // lægger summen af alle rul sammen

        //tjekker om terning et og to har samme værdi eller antal øjne
        if (faces[0] == faces[1]) {
            sameFaceRolls++;
        }
        //holder styr på hvad det højeste rul er
        if ((faces[0] + faces[1]) > largestRoll) {
            largestRoll = (faces[0] + faces[1]);
        }
        //tæller i arryet rollStatistics hver gang en værdi for terningekastne forekommer
        rollStatistics[faces[0] - 1]++;
        rollStatistics[faces[1] - 1]++;

        rollCount++; // tæller antal rul
    }

//    metoden til at printe statistikker efter spillet slutter
    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Sum of dice rolls: ", sumOfDiceRolls); //printer den totale sum af terningerulne
        if (sameFaceRolls == 1) { //tjekker om værdien af sameFaceRolls er 1 for at fjerne flertals s
            System.out.println("The dice rolled the same number " + sameFaceRolls + " time"); //uden flertals s
        } else {
            System.out.println("The dice rolled the same number " + sameFaceRolls + " times"); //med flertals s
        }
        System.out.println("The largest roll was: " + largestRoll); //printer det højeste rul
        System.out.println();
        for (int index = 0; index < 6; index++) {
            System.out.print("You rolled " + (index + 1) + ": ");
            if (rollStatistics[index] == 1) { //tjekker for flertals s
                System.out.println(rollStatistics[index] + " time"); //uden flertals s
            } else {
                System.out.println(rollStatistics[index] + " times"); //med flertals s
            }
        }
        System.out.println();
        System.out.printf("%17s %6d\n", "Amount of  rolls:", rollCount); //printer antallet af rul
    }

}
