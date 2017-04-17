
import java.util.*;

/**
 *
 * @author Cal
 */
public class Morra_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1; //p1=1 -> player is ODDS, p1=2 -> player is EVENS
        int ppoints = 0, cpoints = 0; //Points bookkeeping per game
        int allfingers = 0, pfingers = 0; //Total number of fingers and my fingers
        ArrayList<Integer> compobj = new ArrayList<>();
        ArrayList<Integer> plrobj = new ArrayList<>();
        int cont = 1, numberofgames = 1;
        int compwin = 0, complose = 0, pwin = 0, plose = 0, draw = 0; //Scorekeeping for match
        int p_odd = 0, p_evens = 0;//How many odds/evens

        while (cont == 1) {
            /* Invoke a menu and input selection value */
            p1 = Morramenu.menu();

            /* Selection value to trigger correct behaviour */
            switch (p1) {
                case 1:
                    System.out.println("You picked ODDS.");
                    p_odd = p_odd + 1;
                    break;
                case 2:
                    System.out.println("You picked EVENS.");
                    p_evens = p_evens + 1;
                    break;
                default:
                    System.out.println("Incorrect input, please start over.");
                    p1 = Morraapp.menu(); //Any other input than 1 or 2 will replay the menu
            }

            while (ppoints < 6 && cpoints < 6) {

                pfingers = Morraapp.myfingers(); //My fingers

                /* If the user gives wrong input, ask again */
                while ((pfingers < 1) || (pfingers > 10)) {
                    System.out.println("Sorry, incorrect input.");
                    pfingers = Morraapp.myfingers();
                }
                /*Generate a random number 0-10, this will be the computer's fingers */
                int cfingers = Morraapp.compfingers();

                /* Insert the random numbers in an array for later viewing */
                compobj.add(cfingers);
                plrobj.add(pfingers);

                System.out.println("Computer is showing " + cfingers + " fingers.");
                allfingers = cfingers + pfingers;

                System.out.print("All fingers: " + allfingers + " -- ");
                int mod = allfingers % 2;

                /* This line is for debugging only - comment out in final version*/
                //System.out.println("             Modulus check: " + mod);
                /* Who won this round? */
                if ((p1 == 1 && mod == 1) || (p1 == 2 && mod == 0)) {
                    System.out.println("You win!");
                    ppoints = ppoints + 2;
                } else {
                    System.out.println("You lose.");
                    cpoints = cpoints + 2;
                }
                /* Extra points! */
                if ((allfingers - pfingers) < (allfingers - cfingers)) {
                    ppoints = ppoints + 1;
                    System.out.println("You were closer, extra point awarded.");
                } else if ((allfingers - pfingers) == (allfingers - cfingers)) {
                    System.out.println("Draw - no extra point awarded."); //In the odd chance of a draw
                } else {
                    cpoints = cpoints + 1;
                    System.out.println("Computer was closer, extra point awarded.");
                }
                System.out.println("");
                System.out.println("You: " + ppoints + " Computer: " + cpoints);

            }
            if (ppoints >= 6 && ppoints != cpoints) {
                System.out.println("You're the winner!");
                pwin = pwin + 1;
                complose = complose + 1;
            } else if (ppoints == cpoints) {
                System.out.println("It's a draw!");
                draw = draw + 1;
            } else {
                System.out.print("Computer won. ");
                compwin = compwin + 1;
                plose = plose + 1;
            }

            /* Game over, let's display the played numbers */
            System.out.println("Computer played: " + compobj);

            System.out.println("You played: " + plrobj);
            int aa = 0;
            /* Play again? If unknown input -> loop the question */
            while (aa == 0) {
                System.out.println("Play again? [y/n]");
                String response = sc.next();

                switch (response) {
                    case "y":
                        cont = 1;
                        aa = 1;
                        numberofgames = numberofgames + 1;
                        /* Need to reset the point counter */
                        ppoints = 0;
                        cpoints = 0;
                        break;
                    case "n":
                        cont = 0;
                        aa = 1;
                        break;
                    default:
                        System.out.println("Sorry, invalid answer.");
                        aa = 0;
                }
            }
        }
        System.out.println("Thank you for playing!");
        System.out.println("You played " + numberofgames + " games.");
        System.out.println("Your wins: " + pwin + " your losses: " + plose);
        System.out.println("Computer wins: " + compwin + " computer losses: " + complose);
        System.out.println("Draws: " + draw);
        System.out.println("You played " + p_odd + " time odds and " + p_evens + " times even numbers.");
    }

}
