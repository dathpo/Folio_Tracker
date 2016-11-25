package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.Folio;
import Model.IFolio;
import Model.Stock;

public class FolioTest {

	public void testAddStock() {
		IFolio testFolio = new Folio("test");
		testFolio.addStock("GOOG", 1);
		ArrayList<Stock> holdings = testFolio.getHoldings();
		Stock obj = new Stock("GOOG", 1);
		assertTrue(holdings.contains(obj));
	}

}
