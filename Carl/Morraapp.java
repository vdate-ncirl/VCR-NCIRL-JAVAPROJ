
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cal
 */
public class Morraapp {

    public static int menu() {
        int selection;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number to select:");
        System.out.println("1 - Odds");
        System.out.println("2 - Evens");
        selection = sc.nextInt();
        return selection;
    }

    public static int myfingers() {
        int fing = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many fingers (1 to 10): ");
        fing = sc.nextInt();
        return fing;
    }

    public static int compfingers() {
        int cfing = 0;
        cfing = new Random().nextInt(10) + 1;
        return cfing;
    }

}
