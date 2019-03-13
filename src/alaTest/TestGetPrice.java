package alaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class TestGetPrice {
	PhoneCalls test = new PhoneCalls();
	HashMap<String,Float> operatorA = test.createPriceListA();
	HashMap<String,Float> operatorB = test.createPriceListB();
	float i;
	@Test
	void getPriceForOperatorA() {
		i=test.getPrice("+46-73-212345", operatorA);//operator A holds 1.1 for prefix 46732
		assertEquals(i, (float)1.1);
	}
	@Test
	void getPriceForOperatorB() {
		i=test.getPrice("+46-73-212345", operatorB);//operator B holds 1.0 for prefix 467
		assertEquals(i, (float)1.0);	
	}
	@Test
	void getPriceWhenNoContent() {
		i=test.getPrice("9932183921",operatorA);//operator A does not hold anything for that prefix
		assertEquals(i, (float)-1.0);	
	}
}
