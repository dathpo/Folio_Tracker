package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.Folio;
import Model.IFolio;

public class Testing {

	@Test
	public void testAddStock() {
			IFolio testFolio = new Folio("test");	
			testFolio.addStock("GOOG",1);
		fail("Not yet implemented");
	}

}
