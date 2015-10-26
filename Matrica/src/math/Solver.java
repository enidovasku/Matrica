package math;

public class Solver
{
	private double delta;
	private double x1;
	private double x2;
	
	public double getX1()
	{
		return this.x1;
	}
	
	public double getX2()
	{
		return this.x2;
	}
   //matrica 2x2
   public Solver(double a11, double a12, double a13, double b11, double b12, double b13)
   {
	   this.delta = a11*b12 - a12*b11;
	   this.x2 = (a13*b12 - a12*b13)/this.delta;
	   this.x1 = (a11*b13 - a13*b11)/this.delta;
	   
   }
   
   //matrica 3x3
   public Solver(double a11, double a12, double a13, double a14, double b11, double b12, double b13, double b14, double c11, double c12, double c13, double c14)
   {
	   
   }
}

class Debbuger{
	
	Solver solver = new Solver(1, -1, 1, 1, 1, 3);
	
	
}