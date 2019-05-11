import java.util.*;
public class FibTest {
	
	public static int fibIter(int z) {
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 2; i < z; i++) {
		c = a;
		a += b;
		b = c;
		}
		return a;
	}
	public static int fibRecur(int n)
    {
    if (n <= 1)
       return n;
    return fibRecur(n-1) + fibRecur(n-2);
    }
    public static void main (String[] args)
    {
		double beginTimeOne = System.currentTimeMillis();
		System.out.println(fibIter(Integer.parseInt(args[0])));
		double endTimeOne = System.currentTimeMillis();
		double finalTimeOne = endTimeOne - beginTimeOne;
		System.out.println("Time taken for fibIter: " + finalTimeOne);
		double beginTimeTwo = System.currentTimeMillis();
		System.out.println(fibRecur(Integer.parseInt(args[0])));
		double endTimeTwo = System.currentTimeMillis();
		double finalTimeTwo = endTimeTwo - beginTimeTwo;
		System.out.println("Time taken for fibRecur: " + finalTimeTwo);
    }
}