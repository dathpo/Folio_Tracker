package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Folio;
import model.IFolio;

public class Testing {

	@Test
	public void testAddStock() {
			IFolio testFolio = new Folio("test");	
			testFolio.addStock("GOOG",1);
		fail("Not yet implemented");
	}

}
