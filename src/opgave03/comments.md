Jeres 

    private static int playerTurn = 0;

kan have to værdier 0 og 1 som jeg ser det. Noget der kan have to værdier 
er som regel en boolean. I kunne bruge en boolean

    private static boolean isPlayerOneTurn = true;

Og når der så skal skiftes spiller

    isPlayerOneTurn = !isPlayerOneTurn;

---

Så fint med en metode oneRound der tager en parameter om hvilken spillers tur det er

I kunne have flyttet endnu mere ind i metoden. blandt andet har I nogen næste ens kode 

    System.out.println("*** It's player 1's turn. ***");

    System.out.println("*** It's player 2's turn. ***");

Det kunne I have flyttet ind i oneRound metoden

    System.out.println("*** It's player " + playerNumbers + "'s turn. ***");

---

        return;

på linje 108 behøver I ikke, man returnerer automatisk når man når til enden af en metode.

---

Rigtig god løsning! 