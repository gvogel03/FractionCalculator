package gabe;
import java.util.Scanner;
public class FracCalc{
	public static String fraction(String fraction){
		String fraction1 = fraction.substring(0, fraction.indexOf(" "));
		String fraction2 = fraction.substring(fraction.indexOf(" ") + 3);
		String full = "";
		int whole;
		int numerator = 1;
		int denominator;
		double numdub = 1.0;
		int whole1 = Integer.parseInt(fraction1.substring(0, fraction1.indexOf("_")));
		int numerator1 = Integer.parseInt(fraction1.substring(fraction1.indexOf("_") + 1, fraction1.indexOf("/")));	
		int denominator1 = Integer.parseInt(fraction1.substring(fraction1.indexOf("/") + 1)); 
		int whole2 = Integer.parseInt(fraction2.substring(0, fraction2.indexOf("_")));
		int numerator2 = Integer.parseInt(fraction2.substring(fraction2.indexOf("_") + 1, fraction2.indexOf("/")));	
		int denominator2 = Integer.parseInt(fraction2.substring(fraction2.indexOf("/") + 1)); 
		String operation = fraction.substring(fraction.indexOf(" ") + 1, fraction.indexOf(" ") + 2);
		numerator1 = denominator1 * whole1 + numerator1;
		numerator2 = denominator2 * whole2 + numerator2;
		denominator = denominator1 * denominator2;
		if(operation.equals("+") || operation.equals("-")){
			numerator1 *= denominator2;
			numerator2 *= denominator1;
			if(operation.equals("+"))
				numerator = numerator1 + numerator2;
			else
				numerator = numerator1 - numerator2;
		}
		if(operation.equals("*")){
			numerator = numerator1 * numerator2;
		}
		if(operation.equals("/")){
			numerator1 *= denominator2;
			numerator2 *= denominator1;
			numdub = (double)numerator1 / (double)numerator2;
			return numdub + "";
		}
		full = simplify(numerator, denominator);
		return full;
	}
	public static String simplify(int numerator, int denominator){
		int times = numerator / denominator;
		int leftover = numerator%denominator;
		if(leftover == 0){
			return times + "";
		}
		else{
			return times + "_" + Math.abs(leftover) + "/"  + Math.abs(denominator);
		}
	}
	public static void main(String[]args){
		System.out.println("What is your fraction?, please enter in the form A_B/C +-/* X_Y/Z ");
		Scanner console = new Scanner(System.in);
		String frac = console.nextLine();
		System.out.println(fraction(frac));		
	}
}
