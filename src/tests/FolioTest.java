package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Folio;
import model.IFolio;
import model.Stock;
import quote.Quote;

public class FolioTest {
	
	@Test
	public void testAddStock() {
		IFolio testFolio = new Folio("test");
		testFolio.addStock("GOOG", 1);
		ArrayList<Stock> holdings = testFolio.getHoldings();
		Stock obj = new Stock("GOOG", 1);
		assertTrue(holdings.contains(obj));
	}
	
	
	@Test
	public void testCalculateValue(){
		IFolio testFolio2 = new Folio("test2");
		testFolio2.addStock("GOOG",10);
		testFolio2.addStock("MSFT", 10);
		Quote q = new Quote(false);
		double price=0;
		  try{
			  q.setValues("MSFT");
			  q.setValues("GOOG");
			  price=q.getLatest();
		  }
		  catch (Exception e){
			 e.printStackTrace(); 
		  }
		  System.out.println();
		  assertTrue(!(price == (testFolio2.calculateValue("GOOG")+(testFolio2.calculateValue("MSFT")))));
	}

}
