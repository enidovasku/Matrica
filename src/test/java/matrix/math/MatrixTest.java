package matrix.math;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {
    Matrix matrix;

    @Before
    public void init() {
        double[][] _matrix = new double[][] {{1, 2, 3}, {2, 1, 3}, {3, 2, 1}};
        matrix = new Matrix(_matrix);
    }

    @Test
    public void testItemAtPosition() {
        Assert.assertEquals("Items should match!", 2, matrix.getItemAtPosition(0, 1), 0);
    }
}
