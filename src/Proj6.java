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


        if (args.length > 0) { //if the user has supplied a command line argument
            System.out.println(Arrays.toString(args));


            StringTokenizer st = new StringTokenizer(Arrays.toString(args), "[]"); //gets rid of brackets on args array
            String str = st.nextToken(); //this is our file name that the user has supplied

            System.out.println(str); //testing to see what command line argument was

            Scanner inFile = new Scanner(new File("src/matrixInput/" + str)); // this is the file path



            //create two matrix objects

            //fill them with values using setElem method

            //get the row and column value
            String rowcol = inFile.nextLine();

            StringTokenizer strc = new StringTokenizer(rowcol, " "); //remove the spaces
            int row1 = Integer.parseInt(strc.nextToken());
            int col1 = Integer.parseInt(strc.nextToken());

            Matrix matrix1 = new Matrix(row1, col1); //our first matrix object w/ rows and cols passed in

            //get string representation of matrix, set nextToken() to element in our 2d array

            for (int i = 0; i < row1; i++) { //loops through the rows of the matrix

                /* creates a string array of the line of numbers in the file */
                String pieces1[] = inFile.nextLine().split(" ");

                for (int j = 0; j < col1; j++) { //loops through the columns of the matrix

                    int num = Integer.parseInt(pieces1[j]); //accesses our string array at index j
                    matrix1.setElem(i, j, num); //puts the number we extracted from the string array into our matrix
                }
            }

            inFile.nextLine(); //reads the blank line between the matrices

            String row2col2[] = inFile.nextLine().split(" ");
            int row2 = Integer.parseInt(row2col2[0]);
            int col2 = Integer.parseInt(row2col2[1]);

            Matrix matrix2 = new Matrix(row2, col2);

            for (int i = 0; i < row2; i++) {
                String pieces[] = inFile.nextLine().split(" ");

                for (int j = 0; j < col2; j++) { //loops through the columns of the matrix
                    int num = Integer.parseInt(pieces[j]);
                    matrix2.setElem(i, j, num);
                }
            }

            boolean isError = false; //boolean to check if user has entered a bad answer (isError will equal true then)
            char answer;
            do {

                System.out.print("Enter (p)rint, (a)dd, (s)ubtract, (m)ultiply, (t)ranspose, or (q)uit: \n");
                answer = (s.nextLine().toLowerCase()).charAt(0);

                switch (answer) {
                    case 'p': //this prints out the matrices
                        System.out.println("First:\n");
                        System.out.println(matrix1.toString());
                        System.out.println("Second: \n");
                        System.out.println(matrix2.toString());
                        break;
                    case 'a':
                        if (matrix1.plus(matrix2) == null) System.out.println("Error: the dimensions of the matrices do not match. You cannot add them.");
                        else {
                            System.out.println(matrix1.plus(matrix2));
                        }
                        break;
                    case 's':
                        if (matrix1.minus(matrix2) == null) System.out.println("Error: the dimensions of the matrices do not match. You cannot subtract them.");
                        else {
                            System.out.println(matrix1.minus(matrix2));
                        }
                        break;
                    case 'm':
                        break;
                    case 't':
                        System.out.println("First:\n");
                        System.out.println(matrix1.transpose());
                        System.out.println("Second: \n");
                        System.out.println(matrix2.transpose());
                        break;
                    case 'q':
                        return;
                    default:
                        System.out.println("Error: that is not a valid choice. Please try again.");
                        isError = true;
                        break;
                }
            } while (isError || answer != 'q');

            inFile.close(); //closes connection to .txt file

        } else System.out.println("Error: Please supply a command line argument (ex: 'java Proj6 matrix1.txt')");
    }

}
