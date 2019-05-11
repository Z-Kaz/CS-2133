public class Poly{
	public int[] c;
	public Poly(int[] coefficient){
		for(int i = 0; i<coefficient.length; i++){
			c = coefficient.clone();
		}
	}
	public int degree(){
		for (int i = c.length -1;i>=0;i--){
			if (c[i]!=0){
				return i;
			}
		}
		return -1;
	}
	public String toString(){
		String s = "";
		for(int i = c.length -1;i>=0;i--){
			if(c[i]==0){
				continue;
			}
			else if (c[i]>0&&c[i]==c.length){
				s += "+" + c[i];
			}
			else if (c[i]<0&&c[i]==c.length){
				s+= c[i];
			}
			else if(c[i]>0&&c[i]!=c.length){
				s+= "+" + c[i] + "x^" + i;
			}
			else if (c[i]<0&&c[i]!=c.length){
				s+= "+" + c[i] + "x^" + i;
			}
		}
		return s;
	}
	public Poly add(Poly a){
		int x = a.c.length;
		int y = c.length;
		int[] z;
		if(y>x){
			z = new int[c.length];
			for(int i = 0; i < x;i++){
				z[i] = c[i]+a.c[i];
			}
			for(int i = x;i<y;i++){
				z[i] = c[i];
			}
		}
		else{
			z = new int[a.c.length];
			for(int i = 0;i < y; i++){
				z[i] = c[i]+a.c[i];
			}
			for(int i = y;i<x;i++){
				z[i] = a.c[i];
			}
		}
		return new Poly(z);
	}
	public double evaluate(double x){
		double m = 0;
		for(int i = c.length -1;i>=0;i--){
			m+=c[i]*(Math.pow(x,i));
		}
		return m;
	}
	public static void main(String[] args){
		int[] a = new int[]{4, 0, -8, 0, 3, 2};
		int[] b = new int[]{6, 3, -5, 9, 1, 55, 3};

		Poly j = new Poly(a);
		Poly k = new Poly(b);
		
		
		System.out.println(j.degree());
		System.out.println(j.toString());
		System.out.println(j.evaluate());
		System.out.println(j.add());
		System.out.println(k.degree());
		System.out.println(k.toString());
		//System.out.println(k.evaluate());
		//System.out.println(k.add());
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		