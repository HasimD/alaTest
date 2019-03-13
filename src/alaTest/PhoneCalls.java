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
		int opt = printBestOption(priceA,priceB);
	}

	protected static int printBestOption(float priceA, float priceB) {
		// returns 0 for same price, 1 for price A, 2 for price B, 3 for no suitable operator
		if(priceA==-1.0 && priceB==-1.0) {
			System.out.println("There are no suitable operators.");
			return 3; 
		}
		else if (priceA==-1.0){
			System.out.println("The B option, which is " + priceB + " $ is the best option.");
			return 2; 
		}
		else if (priceB==-1.0) {
			System.out.println("The A option, which is " + priceA + " $ is the best option.");
			return 1; 
		}
		else if(Float.compare(priceA, priceB) < 0){
			System.out.println("The A option, which is " + priceA + " $ is the best option.");
			return 1;
		}
		else if(Float.compare(priceA, priceB) > 0){
			System.out.println("The B option, which is " + priceB + " $ is the best option.");
			return 2;
		}
		else{
			System.out.println("Two options have same prices: " + priceA + " $.");
			return 0;
		}
	}

	protected static float getPrice(String number, HashMap<String, Float> operator) {
		number = number.replaceAll("\\D", "");
		
		for(int i = number.length(); i>0; i-- ) {
			
			String key = number.substring(0, i);
			if(operator.get(key)!=null)
				return operator.get(key);
			
		}
		
		return -1;
	}

	protected static HashMap<String, Float> createPriceListA() {
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
	
	protected static HashMap<String, Float> createPriceListB() {
		HashMap<String,Float> newOperator = new HashMap<String,Float>();
		
		newOperator.put("1", (float) 0.92);
		newOperator.put("44", (float) 0.5);
		newOperator.put("46", (float) 0.2);
		newOperator.put("467", (float) 1.0);
		newOperator.put("48", (float) 1.2);		

		return newOperator;
	}

}
