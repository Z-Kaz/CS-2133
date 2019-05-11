import java.util.*;
public class Ramanujan extends Factorial {

	public static void main(String[] args) {
		double x = 0;
		int n = (Integer.parseInt(args[0]));
		for (int k = 0; k < n; k++) {
			x += ((calculate (4*k)) * (1103 + (26930*k))) / (Math.pow ((calculate (k)),4) * (Math.pow(396,(4 *k))));
		}
		x *= ((2 * Math.sqrt(2))/9801);
		double solution = (x * (Math.pow(Math.PI, 2)));
		System.out.println("Pi According to Ramanujan's series: " + solution);
	}
}