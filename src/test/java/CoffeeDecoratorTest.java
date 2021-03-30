import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoffeeDecoratorTest {
	
	static BuildingOrder order0 ,order1, order2, order3, order4, order5;
	
	@BeforeEach
	void initEach(){
		 order0 = new BuildingOrder();
		 
		 order1 = new BuildingOrder();
		 order1.addExtraShot();
		 
		 order2 = new BuildingOrder();
		 order2.addSugar();
		 order2.addExtraShot();
		 
		 order3 = new BuildingOrder();
		 order3.addVanilla();

		 
		 order4 = new BuildingOrder();
		 order4.addVanilla();
		 order4.addSplenda();
		 
		 order5 = new BuildingOrder();
		 order5.addExtraShot();
		 order5.addSugar();
		 order5.addVanilla();
		 order5.addSplenda();
		 order5.addCream();
		 
		 
	 }
	 

	@Test
	void test1() {
		
		assertEquals(3.99, order0.getTotal(), "Not Expected value!");
	}
	
	@Test
	void test2() {
		
		assertEquals(5.19, order1.getTotal(), "Not Expected value!");
	}
	
	@Test
	void test3() {
		
		assertEquals(5.69, order2.getTotal(), "Not Expected value!");
	}
	
	@Test
	void test4() {
		
		assertEquals(4.99, order4.getTotal(), "Not Expected value!");
	}
	
	@Test
	void test5() {
		
		assertEquals(7.19, order5.getTotal(), "Not Expected value!");
	}
	
	@Test
	void test6() {
		assertEquals(4.49, order3.getTotal(), "Not Expected value!");
	}
	
	
	@Test
	void test7() {
		String expected = "******** New Order ********\n"
				 			+ "Black Coffe: $3.99\n";
		assertEquals(expected, order0.info, "Not Expected value!");
	}
	
	@Test
	void test8() {
		String expected = "******** New Order ********\n"
	 			+ "Black Coffe: $3.99\n"
				+ "+ extra shot: $1.20\n";
		assertEquals(expected, order1.info, "Not Expected value!");
	}
	
	@Test
	void test9() {
		String expected = "******** New Order ********\n"
	 			+ "Black Coffe: $3.99\n"
				+ "+ Vanilla Extract: $.50\n";
		assertEquals(expected, order3.info, "Not Expected value!");
	}
	
	@Test
	void test10() {
		String expected = "******** New Order ********\n"
	 			+ "Black Coffe: $3.99\n"
				+ "+ extra shot: $1.20\n"
	 			+ "+ sugar: $.50\n"
				+ "+ Vanilla Extract: $.50\n" 
	 			+ "+ Splenda: $.50\n"
				+ "+ cream: $.50\n";
		assertEquals(expected, order5.info, "Not Expected value!");
	}
	
	

}
