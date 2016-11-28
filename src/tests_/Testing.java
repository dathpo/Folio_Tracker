package tests_;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model_.Folio;
import model_.IFolio;

public class Testing {

	@Test
	public void testAddStock() {
			IFolio testFolio = new Folio("test");	
			testFolio.addStock("GOOG",1);
		fail("Not yet implemented");
	}

}
