import java.util.EventObject;


public class LayoutEvent extends EventObject{
	
	private int a1,a2,a3,b1,b2,b3;
	private int a4,b4;
	private int c1,c2,c3,c4;
	
	public LayoutEvent(Object source) {
		super(source);
	}
	
	public LayoutEvent(Object source, int a1 ,int a2 , int a3 ,int b1,int b2,int b3){
		super(source);
		
		this.a1 =a1;
		this.a2 = a2; 
		this.a3 = a3;
		this.b1 = b1;
		this.b2 = b2; 
		this.b3 = b3;
	}
	
	public LayoutEvent(Object source, int a1 ,int a2 , int a3 ,int a4,int b1,int b2,int b3 ,int b4 ,int c1, int c2, int c3, int c4){
		super(source);
		
		this.a1 =a1;
		this.a2 = a2; 
		this.a3 = a3;
		this.a4 = a4;
		this.b1 = b1;
		this.b2 = b2; 
		this.b3 = b3;
		this.b4 = b4;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3; 
		this.c4 = c4;
		
	}

	public int getA1() {
		return a1;
	}

	public int getA2() {
		return a2;
	}

	public int getA3() {
		return a3;
	}

	public int getB1() {
		return b1;
	}

	public int getB2() {
		return b2;
	}

	public int getB3() {
		return b3;
	}

	public int getA4() {
		return a4;
	}

	public int getB4() {
		return b4;
	}

	public int getC1() {
		return c1;
	}

	public int getC2() {
		return c2;
	}

	public int getC3() {
		return c3;
	}

	public int getC4() {
		return c4;
	}
}
