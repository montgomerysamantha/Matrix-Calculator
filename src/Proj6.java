/**
 * This class, Proj6, contains the main method.
 *
 * @author Samantha Montgomery
 * @version 6
 * Lab: Friday 7:30
 */

import java.util.*;
import java.io.*;

public class Proj6 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);


        if (args.length > 0) { //if the user has entered a valid file name
            System.out.println(Arrays.toString(args));


            StringTokenizer st = new StringTokenizer(Arrays.toString(args), "[]"); //gets rid of brackets on args array
            String str = st.nextToken(); //this is our file name that the user has supplied

            if (args.length > 0) {
                System.out.println(str);
            }

            Scanner inFile = new Scanner(new File("src/matrixInput/" + str)); // this is the file path

            inFile.close();

        }


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
