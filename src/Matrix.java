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

        return null;
    }

    public Matrix minus(Matrix m) {

        return null;
    }

    public Matrix times(Matrix m) {

        return null;
    }

    public Matrix transpose() {

        return null;
    }
}
