package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Stock;
import quote.Quote;

public class StockTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQuantity() {
		Stock t1 = new Stock("GOOGL", 1);
		t1.setQuantity(100);
		assertTrue(t1.getQuantity()==100);
	}
	@Test
	public void testGetPrice(){
		Stock t1 = new Stock("MSFT",10);
		Quote q = new Quote(false);
		double price=0;
		  try{
			  q.setValues("MSFT");
			  price=q.getLatest();
		  }
		  catch (Exception e){
			 e.printStackTrace(); 
		  }
		  assertTrue(price == t1.getPrice());
	}
	

}
