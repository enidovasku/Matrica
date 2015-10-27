package matrix.math;

public class Solver {
    private boolean stop = false;//stop from incrementing phase

    private double delta;
    private double x1;
    private double x2;
    private double x3;
    private String unexpectedResult;

    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getX3() {
        return this.x3;
    }

    public double getDelta() {
        return this.delta;
    }

    //gjeneron matricen e fazes se radhes/
    public Matrix generateNextMatrice(Matrix inputMatrix, int phase) {
        double multiplyer;
        if (!inputMatrix.type) {
            if (phase == 1) {
                if ((inputMatrix.a1 == 0 && inputMatrix.b1 == 0) || (inputMatrix.a2 == 0 && inputMatrix.b2 == 0))
                    this.unexpectedResult = "Ky sistem ekuacionesh nuk ka zgjidhje";

                if (inputMatrix.a1 == 0) this.x2 = inputMatrix.a3 / inputMatrix.a2;
                else {
                    //multiply by some factor to make the key 1
                    multiplyer = 1 / inputMatrix.a1;
                    inputMatrix.a1 = inputMatrix.a1 * (multiplyer);
                    inputMatrix.a2 = inputMatrix.a2 * (multiplyer);
                    inputMatrix.a3 = inputMatrix.a3 * (multiplyer);

                }
                if (inputMatrix.b1 == 0) this.x2 = inputMatrix.b3 / inputMatrix.b2;
                else {
                    multiplyer = 1 / inputMatrix.b1;
                    inputMatrix.b1 = inputMatrix.b1 * (multiplyer);
                    inputMatrix.b2 = inputMatrix.b2 * (multiplyer);
                    inputMatrix.b3 = inputMatrix.b3 * (multiplyer);
                    //TO BE CHANGED

                    System.out.println(phase + " -> ");
                    inputMatrix.printValues();
                }
            } else if (phase == 2) {
                //substract
                inputMatrix.b1 = inputMatrix.b1 - inputMatrix.a1;
                inputMatrix.b2 = inputMatrix.b2 - inputMatrix.a2;
                inputMatrix.b3 = inputMatrix.b3 - inputMatrix.a3;
                //TO BE CHANGED

                System.out.println(phase + " -> ");
                inputMatrix.printValues();
            } else if (phase == 3) {
                multiplyer = 1 / inputMatrix.b2;
                inputMatrix.b2 = inputMatrix.b2 * (multiplyer);
                inputMatrix.b3 = inputMatrix.b3 * (multiplyer);
                //TO BE CHANGED

                System.out.println(phase + " -> ");
                inputMatrix.printValues();
            } else if (phase == 4) {
                multiplyer = inputMatrix.a2 / inputMatrix.b2;
                inputMatrix.a2 = 0;
                inputMatrix.a3 = inputMatrix.a3 - (multiplyer * inputMatrix.b3);
                this.x1 = inputMatrix.a3;
                this.x2 = inputMatrix.b3;
                this.stop = true;
                //TO BE CHANGED

                System.out.println(phase + " -> ");
                inputMatrix.printValues();
            }
            phase++;
        } else {
            //3x3 matrice <---- HERE
        }


        if (this.stop) {
            return inputMatrix;
        } else {
            return generateNextMatrice(inputMatrix, phase);
        }
    }


}
