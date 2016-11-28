package tests_;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model_.Folio;
import model_.IFolio;
import model_.Stock;

public class FolioTest {

	public void testAddStock() {
		IFolio testFolio = new Folio("test");
		testFolio.addStock("GOOG", 1);
		ArrayList<Stock> holdings = testFolio.getHoldings();
		Stock obj = new Stock("GOOG", 1);
		assertTrue(holdings.contains(obj));
	}

}
