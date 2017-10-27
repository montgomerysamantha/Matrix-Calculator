public class Matrix {
    private int[][] arr;
    private int r;
    private int c;

    public Matrix(int row, int col) {
        r = row;
        c = col;
        arr = new int[r][c]; //allocating space for the 2d array
    }

    public void setElem(int row, int col, int value) {

        arr[row][col] = value;
        //sets the indices of the 2d array you're accessing to the value you passed in when calling setElem
    }

    public String toString() {
        /* returns a string representation of the matrix */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j] + " ");
            }
           sb.append("\n");
        }

        return sb.toString();
    }

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

    public Matrix times(Matrix m) {

        return null;
    }

    public Matrix transpose() {
        //rows become columns and columns become rows

        Matrix m = new Matrix(c, r);

        int trows = c;
        int tcols = r;

        for (int i = 0; i < trows; i++) { //looping through our new rows
            for (int j = 0; j < tcols; j++) { //looping through our new columns
                m.arr[i][j] = arr[j][i];
            }
        }

        return m;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

