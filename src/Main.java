import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void trickyHanoi ( int disks )
    {
        trickyHanoiAux ( disks, 'A', 'C', 'B' );
    }
    /**
     * trickyHanoi() helper method. See trickyHanoi().
     * @param disks disks passed from trickyHanoi
     * @param from Holds peg A when passed, overall the beginning stage of turn
     * @param to  Holds peg C when passed, overall the end stage of turn
     * @param using  Holds peg B when passed, overall the peg not being used, will never be B
     */
    public static void trickyHanoiAux ( int disks, char from, char
            to, char using ) {
        //base is 1 and always prints twice in order to get from A to C then C to A
        if (disks == 1) {
            System.out.println("Move disk 1 from peg " + from + " to peg " + using); //Move it from the start to the second
            System.out.println("Move disk 1 from peg " + using + " to peg " + to); //Move it from the second to the end
        } else {
            //does first segment to get largest disk from A to B
            trickyHanoiAux(disks - 1, from, to, using);
            System.out.println("Move disk " + disks + " from peg " + from + " to peg " + using);
            //does segment to get largest disk from B to C
            trickyHanoiAux(disks - 1, to, from, using);
            System.out.println("Move disk " + disks + " from peg " + using + " to peg " + to);
            //Follows up to get all the remaining disks on top of the largest disk at C
            trickyHanoiAux(disks - 1, from, to, using);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of disks: ");

        trickyHanoi(in.nextInt());
        }
    }
