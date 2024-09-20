package opgave02;

import java.util.Scanner;

public class Craps {


    public static void main(String[] args) {
        System.out.println("Welcome to crabs!");
        printRules(); //printer spillets regler

        playCrabs(); //metoden der starter spillet

        System.out.println("Thank you for playing crabs.");
    }

    private static void playCrabs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Roll the dice? (yes/no): "); //spilleren bliver spurgte om de vil rulle terningerne
        String answer = scanner.nextLine(); //svaret gemmes i strengen answer

        while (!answer.equals("no")) { //loop der gentager spillet så længe spilleren ikke skriver no

            int diceRoll = rollDice(); //kalder på metoden rollDice for at rulle terningerne
            System.out.println("You rolled a: " + diceRoll); //printer terningeslaget

            //hvis spilleren vinder spillet
            if (diceRoll == 7 || diceRoll == 11) {
                System.out.println("You won!");
            } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) { //hvis spilleren taber spillet
                System.out.println("You lost.");
            } else { //hvis spillet fortsætter med point roll
                System.out.println("The game continues with " + diceRoll + " as the point.");
                /*metoden rollForPoint ruller for point og returnere hvorvidt spilleren vandt eller tabte
                denne metode tager en parameter til det slag som blev point*/
                if(rollForPoint(diceRoll)) {
                    System.out.println("You won the point roll!");
                } else {
                    System.out.println("You lost the point roll.");
                }

            }
            //spørg spilleren om de vil spille igen og stopper loopet med svaret no
            System.out.print("Do you wanna play again? (yes/no): ");
            answer = scanner.nextLine();
            scanner.close();
        }
    }
    //metoden til at rulle for point
    private static boolean rollForPoint(int point) {
        int newRoll = rollDice(); //rul for point
        System.out.println("Your roll for point is: " + newRoll); //printer slaget
        /*lykket til at fortsætte med at rulle for point,
        hvis spillet ikke afsluttes efter et slag*/
        while (newRoll != point && newRoll != 7) {
            System.out.println("You keep rolling.");
            newRoll = rollDice();
            System.out.println("Your new roll for point is: " + newRoll);
            }
        if (newRoll == point) { //hvis spilleren vinder point
            return true;
        } else {
            return false; //hvis spilleren ikke vinder
        }
    }
        //metoden returnere sum af to terningeslag
    private static int rollDice() {
        return (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
    }
        //spillets regler
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
