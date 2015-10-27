package matrix.math;

/**
 * The {@code Matrix} class creates a Matrix instance from a 2D array
 * and also holds methods for manipulating the Matrix.
 */
public class Matrix {
    //TODO: Defensive programming: Matrix should be square

    //TODO: Remove these two lines. Create matrix as array of arrays
    public boolean type; //c'lloj matrice jam? 0-2x2||1-3x3/
    public double a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4;
    private double[][] matrix;

    /**
     * Protected empty constructor to not permit the creation of
     * empty matrices
     */
    protected Matrix() {
    }

    /**
     * Constructor to create a {@code Matrix} instance from a 2D array
     *
     * @param matrix The 2D array, which should be a square array
     * @author Aldo Ziflaj
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Stringifies the value of the matrix and prints it for logging purposes
     *
     * @return The stringified value of the matrix
     */
    public String printValues() {
        StringBuilder sb = new StringBuilder();
        for (double[] arr : matrix) {
            for (double item : arr) {
                sb.append(item).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    /**
     * Returns the Matrix item at a given position
     *
     * @param row The row of the item to get
     * @param col The column of the item to get
     * @return The item at the given position
     * @author Aldo Ziflaj
     */
    public double getItemAtPosition(int row, int col) {
        return matrix[row][col];
    }

    public double[][] getMatrixAsArray() {
        return matrix;
    }

    /**
     * Returns the minor of the matrix for a given row and columnt
     *
     * @param row The given row for the minor matrix
     * @param col The given column for the minor matrix
     * @return The minor matrix
     * @author Aldo Ziflaj
     */
    public Matrix getMinor(int row, int col) {
        int dim = matrix[0].length;
        int nDim = dim - 1;
        double[][] minor = new double[nDim][nDim];

        int a = 0, b = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i != row && j != col) { //elem. of minor
                    minor[a][b] = matrix[i][j];
                    b++;
                    if (b == nDim) {
                        b = 0;
                    }
                }
            }
            if (i != row) {
                a++;
            }
        }

        return new Matrix(minor);
    }
}
