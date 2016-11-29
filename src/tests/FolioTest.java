package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Folio;
import model.IFolio;
import model.IStock;
import model.Stock;
import quote.IQuote;
import quote.Quote;

public class FolioTest {
	
	@Test
	public void testAddStock() {
		IFolio folio = new Folio("test");
		IStock stock = new Stock("GOOG", 1);
		folio.addStock(stock);
		ArrayList<IStock> stocks = folio.getStocks();
		assertTrue(stocks.contains(stock));
	}
	
	
	@Test
	public void testCalculateValue(){
		IFolio testFolio2 = new Folio("test2");
		IStock stock1 = new Stock("MSFT", 1);
		IStock stock2 = new Stock("GOOG", 2);
		testFolio2.addStock(stock1);
		testFolio2.addStock(stock2);
		IQuote q = new Quote(false);
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
