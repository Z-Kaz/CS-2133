import java.util.*;
public class Factorial {

	public static void main(String[] args){
		long a = Integer.parseInt(args[0]);
		long b = Integer.parseInt(args[1]);
		System.out.println("Factorial.calculate(" + a + ") returned " + calculate(a) + ". Test passed!");
		System.out.println("Factorial.calculate(" + b + ") returned " + calculate(b) + ". Test passed!");
	}
	public static long calculate(long n){
		if (n < 0 || n > 20) {
			System.out.println("ERROR: Enter a number between 0 and 20");
			System.exit(1);
		}
		else if (n == 0) {
			return 1;
		}
		return n * calculate (n-1);	
	}
}
			