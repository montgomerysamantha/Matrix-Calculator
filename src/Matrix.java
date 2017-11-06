/**
 * This class, Matrix, contains methods called by the Proj6 class (main)
 * that help with the adding, subtracting, multiplying, and transposing
 * of the matrices.
 *
 * @author Samantha Montgomery
 * @version 6
 * Lab: Friday 7:30
 */

public class Matrix {
    private int[][] arr;
    private int r;
    private int c;

    //this is the constructor, it initializes our variables
    public Matrix(int row, int col) {
        r = row;
        c = col;
        arr = new int[r][c]; //allocating space for the 2d array
    }

    /**
     * setElem(int row, int col, int value)
     *
     * This method takes in an integer value for
     * rows, columns, and the actual value. It then
     * sets this actual value in the 2D array that the
     * Matrix object, at the row and col specified.
     *
     * @param row - the row of the 2D integer array that we're accessing
     * @param col - the column of the 2D integer array that we're accessing
     * @param value - the value we want to put into the array
     * @return void - nothing
     */
    public void setElem(int row, int col, int value) {

        arr[row][col] = value;
        //sets the indices of the 2d array you're accessing to the value you passed in when calling setElem
    }

    /**
     * toString
     * Replaces the default toString() method for the Object class.
     * This method creates a new StringBuilder and appends on every value
     * in the matrix as well as a tab character ('\t'). Finally, it
     * turns the StringBuilder into a string, and then returns the
     * string.
     *
     * @return a string representation of the matrix object
     */
    public String toString() {
        /* returns a string representation of the matrix */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j] + "\t");
            }
           sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * plus(Matrix m)
     * This method can be called on a matrix object and you
     * can also pass in another matrix object as a parameter.
     * It then returns the sum of the two as a 'sum' matrix object.
     * tl;dr: It adds the matrices.
     *
     * @param Matix m - the matrix you want to add to your other matrix
     * @return Matrix sum - the two matrices added together.
     */
    public Matrix plus(Matrix m) {

        Matrix sum = new Matrix(r,c); //this is what our method will return
        if (r == m.r && c == m.c) {
            for (int i = 0; i < r; i++) { //loops through the rows of our matrix
                for (int j = 0; j < c; j++) { //loops through the columns

                    int add = arr[i][j] + m.arr[i][j]; //adding up the values at the specific index

                    sum.setElem(i, j, add); //sets the value of 'sum' matrix to the operation we did (adding)
                }
            }
            return sum;
        }
        return null; //returns null if the dimensions don't match
    }

    /**
     * minus(Matrix m)
     * This method can be called on a matrix object and you
     * can also pass in another matrix object as a parameter.
     * It then returns the sum of the two as a 'difference' matrix object.
     * tl;dr: It subtracts the matrices.
     *
     * @param Matix m - the matrix you want to subtract from your other matrix
     * @return Matrix difference - the two matrices subtracted from eachother.
     */
    public Matrix minus(Matrix m) {
        Matrix difference = new Matrix(r,c); //this is what our method will return

        if (r == m.r && c == m.c) {
            for (int i = 0; i < r; i++) { //loops through the rows of our matrix
                for (int j = 0; j < c; j++) { //loops through the columns

                    int subtract = arr[i][j] - m.arr[i][j]; //adding up the values at the specific index

                    difference.setElem(i, j, subtract); //sets the value of 'difference' matrix to the operation we did (subtracting)
                }
            }
            return difference;
        }
        return null; //returns null if the dimensions don't match
    }

    /**
     * times(Matrix m)
     * This method can be called on a matrix object and you
     * can also pass in another matrix object as a parameter.
     * It then returns the product of the two as a 'product' matrix object.
     * tl;dr: It multiplies the matrices.
     *
     * @param Matix m - the matrix you want to multiply with your other matrix
     * @return Matrix product - the two matrices multiplied by eachother.
     */
    public Matrix times(Matrix m) {
        //the size of our product matrix will have dimensions that are the rows of our first matrix and the cols of matrix m
        Matrix product = new Matrix(r, m.c); //m.c = column value for matrix m
        if (c == m.r) {
            /* if the cols of matrix 1 match the rows of matrix m
            * ex: matrix 1 w/ dimensions (2 x 4) and matrix m w/ dimensions (4 x 3) would work
            */
            for (int i = 0; i < product.r; i++) { //loops through the rows of our product matrix
                for (int j = 0; j < product.c; j++) { //loops through the columns of our product matrix

                    int num = 0;
                    int total = 0;

                    for (int k = 0; k < c; k++) { //loops through the column value (from the original matrix the method was called on)
                            num = arr[i][k] * m.arr[k][j];

                            total += num; //adds them all up
                    }
                    product.setElem(i, j, total); //sets total to the proper spot in the 2D array of the matrix
                }
            }
            return product;
        }

        return null; //returns null if the dimensions don't pass the if statement
    }

    /**
     * transpose()
     * This method can be called on a matrix object.
     * It then returns a new matrix object that 'flips' the original matrix
     * object that it was called on (the rows of orig matrix become columns of new matrix
     * and cols of orig matrix become rows of the new matrix that we're returning.
     * tl;dr: It flips the matrix.
     *
     * @return Matrix m - the new flipped matrix.
     */
    public Matrix transpose() {
        //rows become columns and columns become rows

        Matrix m = new Matrix(c, r);

        int trows = c; //new rows = cols of orig. matrix
        int tcols = r; //new cols = rows of orig. matrix

        for (int i = 0; i < trows; i++) { //looping through our new rows
            for (int j = 0; j < tcols; j++) { //looping through our new columns
                m.arr[i][j] = arr[j][i]; //switching the values
            }
        }

        return m;
    }
}
