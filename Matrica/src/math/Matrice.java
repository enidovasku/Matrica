package math;

import java.math.BigDecimal;

public class Matrice
{
	public boolean type; //c'lloj matrice jam? 0-2x2||1-3x3/
	public double a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4;
	public String formatedMatrice;
	
    public Matrice(double a1, double a2, double a3, double b1, double b2, double b3)
    {
		 this.a1 = truncate(a1); this.a2 = truncate(a2); this.a3 = truncate(a3); this.b1 = truncate(b1); this.b2 = truncate(b2); this.b3 = truncate(b3);
	     this.type = false;
    }
	 
    public Matrice(double a1, double a2, double a3, double a4, double b1, double b2, double b3, double b4, double c1, double c2, double c3, double c4)
	{
	   this.a1 = a1; this.a2 = a2; this.a3 = a3; this.a4 = a4; this.b1 = b1; this.b2 = b2; this.b3 = b3;  this.b4 = b4; this.c1 = c1; this.c2 = c2; this.c3 = c3; this.c4 = c4;
	   this.type = true;
    }
    
    public String returnValues()
    {
    	if(this.type == false)
    	{
    	   this.formatedMatrice = this.a1+" "+this.a2+" | "+this.a3 + "\n" +this.b1+" "+this.b2+" | "+this.b3;
    	   return this.formatedMatrice;
    	}
    	else return null;
    }
    
    public double truncate(double n)
    {
    	BigDecimal bd = new BigDecimal(n);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
   
    //testing
    public static void main(String[] args)
    {
        Matrice m = new Matrice(1,2,3,-3,2,4);
        Solver s = new Solver(m);
    	System.out.println(s.getX1());
    }
}
