/**
 * This class, Proj6, contains the main method.
 *
 * @author Samantha Montgomery
 * @version 6
 * Lab: Friday 7:30
 */

import java.util.*;

public class Proj6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        boolean isError; //boolean to check if user has entered a bad answer (isError will equal true then)
        do {

            System.out.print("Enter (p)rint, (a)dd, (s)ubtract, (m)ultiply, (t)ranspose, or (q)uit: ");
            char answer = (s.nextLine().toLowerCase()).charAt(0);

            switch (answer) {
                case 'p':
                    isError = false;
                    break;
                case 'a':
                    isError = false;
                    break;
                case 's':
                    isError = false;
                    break;
                case 'm':
                    isError = false;
                    break;
                case 't':
                    isError = false;
                    break;
                case 'q':
                    isError = false;
                    break;
                default:
                    System.out.println("Error: that is not a valid choice. Please try again.");
                    isError = true;
                    break;
            }
        } while (isError);
    }

}
