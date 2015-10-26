package math;

public class Solver
{
	private double delta;
	private double x1;
	private double x2;
	private double x3;
	
	public double getX1()
	{
		return this.x1;
	}
	
	public double getX2()
	{
		return this.x2;
	}
	
	public double getX3()
	{
		return this.x3;
	}
	
	public double getDelta()
	{
		return this.delta;
	}
   
   //solving with KRAMER
   //matrica 2x2
   public Solver(double a11, double a12, double a13, double b11, double b12, double b13)
   {
	   this.delta = this.percaktorSolver(a11, a12, b11, b12);
	   this.x2 = this.percaktorSolver(a11, a13, b11, b13)/this.delta;
	   this.x1 = this.percaktorSolver(a13, a12, b13, b12)/this.delta;
	   
   }
   
   //matrica 3x3
   public Solver(double a11, double a12, double a13, double a14, double b11, double b12, double b13, double b14, double c11, double c12, double c13, double c14)
   {
	   this.delta = a11*this.percaktorSolver(b12, b13, c12, c13) - b11*this.percaktorSolver(a12, a13, c12, c13) + 
			   c11*this.percaktorSolver(a12, a13, b12, b13);
	   
	   this.x1 = (a14*this.percaktorSolver(b12, b13, c12, c13) - b14*this.percaktorSolver(a12, a13, c12, c13) + 
			   c14*this.percaktorSolver(a12, a13, b12, b13))/this.delta;
	   
	   this.x2 = (a11*this.percaktorSolver(b14, b13, c13, c13) - b11*this.percaktorSolver(a14, a13, c14, c13) + 
			   c11*this.percaktorSolver(a14, a13, b14, b13))/this.delta;
	   
	   this.x3 = (a11*this.percaktorSolver(b12, b14, c12, c14) - b11*this.percaktorSolver(a12, a14, c12, c14) + 
			   c11*this.percaktorSolver(a12, a14, b12, b14))/this.delta;
   }
   
    //2x2 percaktor solver
 	public double percaktorSolver(double a11, double a12, double b11, double b12)
 	{
 		return a11*b12 - a12*b11;
 	}
}

class Debbuger{
	
	Solver solver = new Solver(1, -1, 1, 1, 1, 3);
	
	
}