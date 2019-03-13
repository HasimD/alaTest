package alaTest;

import java.util.HashMap;
import java.util.Scanner; 

public class PhoneCalls {
	
	public static void main(String args[]) {
		
		HashMap<String,Float> operatorA = createPriceListA();
		HashMap<String,Float> operatorB = createPriceListB();
		System.out.println("Input the number : ");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		float priceA = getPrice(number,operatorA);
		float priceB = getPrice(number,operatorB);
		printBestOption(priceA,priceB);
	}

	private static void printBestOption(float priceA, float priceB) {
		if(priceA==-1.0 && priceB==-1.0)
			System.out.println("There are no suitable operators.");
		else if (priceA==-1.0)
			System.out.println("The B option, which is " + priceB + " $ is the best option.");
		else if (priceB==-1.0)
			System.out.println("The A option, which is " + priceA + " $ is the best option.");
		else if(Float.compare(priceA, priceB) < 0)
			System.out.println("The A option, which is " + priceA + " $ is the best option.");
		else if(Float.compare(priceA, priceB) > 0)
			System.out.println("The B option, which is " + priceB + " $ is the best option.");
		else
			System.out.println("Two options have same prices: " + priceA + " $.");
	}

	private static float getPrice(String number, HashMap<String, Float> operator) {
		number = number.replaceAll("\\D", "");
		
		for(int i = number.length(); i>0; i-- ) {
			
			String key = number.substring(0, i);
			if(operator.get(key)!=null)
				return operator.get(key);
			
		}
		
		return -1;
	}

	private static HashMap<String, Float> createPriceListA() {
		HashMap<String,Float> newOperator = new HashMap<String,Float>();
		
		newOperator.put("1", (float) 0.9);
		newOperator.put("268", (float) 5.1);
		newOperator.put("46", (float) 0.17);
		newOperator.put("4620", (float) 0.0);
		newOperator.put("468", (float) 0.15);
		newOperator.put("4631", (float) 0.15);
		newOperator.put("4673", (float) 0.9);
		newOperator.put("46732", (float) 1.1);
		

		return newOperator;
	}
	
	private static HashMap<String, Float> createPriceListB() {
		HashMap<String,Float> newOperator = new HashMap<String,Float>();
		
		newOperator.put("1", (float) 0.92);
		newOperator.put("44", (float) 0.5);
		newOperator.put("46", (float) 0.2);
		newOperator.put("467", (float) 1.0);
		newOperator.put("48", (float) 1.2);		

		return newOperator;
	}

}
