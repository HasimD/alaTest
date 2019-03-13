package alaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPrintBestOption {

	int i;
	PhoneCalls test = new PhoneCalls();
	
	
	@Test
	void noValuesForBoth() {
		i=test.printBestOption(-1, -1);
		assertEquals(3, i);
	}
	@Test
	void withCheaperPriceA() {
		i=test.printBestOption((float)1.0, (float)2.0);
		assertEquals(1, i);
	}
	@Test
	void withCheaperPriceB() {
		i=test.printBestOption((float)2.0, (float)1.0);
		assertEquals(2, i);
	}
	@Test
	void withoutVauleOfA() {
		i=test.printBestOption(-1, (float)1.0);
		assertEquals(2, i);
	}
	@Test
	void withoutVauleOfB() {
		i=test.printBestOption((float)1.0, -1);
		assertEquals(1, i);
	}
	@Test
	void whileInEqualCondition() {
		i=test.printBestOption((float)1.0, (float)1.0);
		assertEquals(0, i);
	}


}
