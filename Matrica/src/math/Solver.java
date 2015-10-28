package math;

public class Solver
{
	private boolean stop = false;//stop from incrementing phase
	
	private double delta;
	private double x1;
	private double x2;
	private double x3;
	private String unexpectedResult;
	private String solution;
	private int phases;
	private String[] matriceState = new String[4];
		
	public int getPhases() {
		return phases;
	}

	public String getMatriceState(int phase) {
		return matriceState[phase];
	}

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
	public String getSolution()
	{
		return this.solution;
	}
	
	public Solver(Matrice inputMatrice)
	{
		generateNextMatrice(inputMatrice, 1);
	}
	//gjeneron matricen e fazes se radhes/
	public Matrice generateNextMatrice(Matrice inputMatrice, int phase)
	{
		double multiplyer;
		if(inputMatrice.type == false)
		{
			if(phase == 1)
			{				
				if((inputMatrice.a1 == 0 && inputMatrice.b1 == 0)||(inputMatrice.a2 == 0 && inputMatrice.b2 == 0)) 
				{	
					this.unexpectedResult = "Ky sistem ekuacionesh nuk ka zgjidhje";
				    this.solution = this.unexpectedResult;
				    return null;
				}
				if(inputMatrice.a1 == 0) this.x2 = inputMatrice.a3/inputMatrice.a2; 
				else
				{
				  //multiply by some factor to make the key 1
				  multiplyer = 1/inputMatrice.a1;
				  inputMatrice.a1 = inputMatrice.a1*(multiplyer);
				  inputMatrice.a2 = inputMatrice.a2*(multiplyer);
				  inputMatrice.a3 = inputMatrice.a3*(multiplyer);
				  				  
				}
				if(inputMatrice.b1 == 0) this.x2 = inputMatrice.b3/inputMatrice.b2;
				else
				{	
				  multiplyer = 1/inputMatrice.b1;	
				  inputMatrice.b1 = inputMatrice.b1*(multiplyer);
				  inputMatrice.b2 = inputMatrice.b2*(multiplyer);
				  inputMatrice.b3 = inputMatrice.b3*(multiplyer);
                  
				  
				  this.matriceState[0] = "Faza e pare"+" -> \n"+ inputMatrice.returnValues();
				  
				}
			}
			
			else if(phase == 2)
			{
				//substract
				inputMatrice.b1 = inputMatrice.b1 - inputMatrice.a1;	
				inputMatrice.b2 = inputMatrice.b2 - inputMatrice.a2;	
				inputMatrice.b3 = inputMatrice.b3 - inputMatrice.a3;	
                
				this.matriceState[1] = "\nFaza e dyte"+" -> \n"+ inputMatrice.returnValues();
			}
			
			else if(phase == 3)
			{
				multiplyer = 1/inputMatrice.b2;
				inputMatrice.b2 = inputMatrice.b2*(multiplyer);	
				inputMatrice.b3 = inputMatrice.b3*(multiplyer);	

				this.matriceState[2] = "\nFaza e trete"+" -> \n"+ inputMatrice.returnValues();				  
			
			}
			
			else if(phase == 4)
			{
				multiplyer = inputMatrice.a2/inputMatrice.b2;
				inputMatrice.a2 = 0;
				inputMatrice.a3 = inputMatrice.a3 - (multiplyer*inputMatrice.b3);
				this.x1 = inputMatrice.a3;
				this.x2 = inputMatrice.b3;
				this.stop = true;
				
				this.matriceState[3] = "\nFaza e katert"+" -> \n"+ inputMatrice.returnValues();
				  
			
			}
			phase++;
			this.solution = "Zgjidhje :"+ this.x1 + " " + this.x2;
			this.phases = phase-1;
		}
		
		else
		{
			//3x3 matrice <---- HERE
		}
		
		
		if(this.stop == true) return inputMatrice;	
		else return generateNextMatrice(inputMatrice, phase);
	}
   
   
}

   


