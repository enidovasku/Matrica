package math;

public class Solver
{
	private boolean stop = false;//stop from incrementing phase
	
	private double delta;
	private double x1;
	private double x2;
	private double x3;
	private String unexpectedResult;
	
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
	
	//gjeneron matricen e fazes se radhes
	public Matrice generateNextMatrice(Matrice inputMatrice, int phase)
	{
		if(inputMatrice.type == false)
		{
			if(phase == 1)
			{				
				if((inputMatrice.a1 == 0 && inputMatrice.b1 == 0)||(inputMatrice.a2 == 0 && inputMatrice.b2 == 0)) 
					this.unexpectedResult = "Ky sistem ekuacionesh nuk ka zgjidhje";
				
				if(inputMatrice.a1 == 0) this.x2 = inputMatrice.a3/inputMatrice.a2; 
				else
				{
				  //multiply by some factor to make the key 1
				  inputMatrice.a1 = inputMatrice.a1*(1/inputMatrice.a1);
				  inputMatrice.a2 = inputMatrice.a2*(1/inputMatrice.a1);
				  inputMatrice.a3 = inputMatrice.a3*(1/inputMatrice.a1);
				}
				if(inputMatrice.b1 == 0) this.x2 = inputMatrice.b3/inputMatrice.b2;
				else
				{	
				  inputMatrice.b1 = inputMatrice.b1*(1/inputMatrice.b1);
				  inputMatrice.b2 = inputMatrice.b2*(1/inputMatrice.b1);
				  inputMatrice.b3 = inputMatrice.b3*(1/inputMatrice.b1);
				}
			}
			
			else if(phase == 2)
			{
				//substract
				inputMatrice.b1 = inputMatrice.b1 - inputMatrice.a1;	
				inputMatrice.b2 = inputMatrice.b2 - inputMatrice.a2;	
				inputMatrice.b3 = inputMatrice.b3 - inputMatrice.a3;		
			}
			
			else if(phase == 3)
			{
				//substract
				inputMatrice.b2 = inputMatrice.b2*(1/inputMatrice.b2);	
				inputMatrice.b3 = inputMatrice.b3*(1/inputMatrice.b2);		
			}
			
			else if(phase == 4)
			{
				double mul = inputMatrice.a2/inputMatrice.b2;
				inputMatrice.a2 = 0;
				inputMatrice.a3 = inputMatrice.a3 - mul*inputMatrice.b3;
				this.x1 = inputMatrice.a3;
				this.x2 = inputMatrice.b3;
				this.stop = true;
			}
			phase++;
		}
		
		else
		{
			//3x3 matrice <---- HERE
		}
		
		
		if(this.stop == true) return inputMatrice;	
		else return generateNextMatrice(inputMatrice, phase);
	}
   
   
}

   


