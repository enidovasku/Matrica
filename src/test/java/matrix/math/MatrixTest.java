package matrix.math;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * Test class for {@code matrix.math.Matrix} class
 */
public class MatrixTest {
    Matrix matrix;
    double[][] _matrix;

    @Before
    public void init() {
        _matrix = new double[][] {{1, 2, 3}, {2, 1, 3}, {3, 2, 1}};
        matrix = new Matrix(_matrix);
    }

    @Test
    public void testItemAtPosition() {
        Assert.assertEquals("Items should match!", 2, matrix.getItemAtPosition(0, 1), 0);
    }

    @Test
    public void testMatrixAsArray() {
        //TODO: Method is deprecated; change
        Assert.assertEquals("Matrix and array don't match", _matrix, matrix.getMatrixAsArray());
    }

    @Test
    public void testMinorOfMatrix() {
        Matrix minorMatrix = matrix.getMinor(0, 0);
        double[][] _minor = new double[][] {{1, 3}, {2, 1}};
        //TODO: Method is deprecated; change
        Assert.assertEquals("Matrix and array don't match: " + minorMatrix.printValues(), _minor, minorMatrix.getMatrixAsArray());
    }
}
