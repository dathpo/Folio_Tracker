package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Folio;
import Model.IFolio;

public class FolioTest {

	@Test
	public void testAddStock() {
			IFolio testFolio = new Folio("test");	
			testFolio.addStock("GOOG",1);
			
	}

}
