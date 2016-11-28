package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Folio;
import model.IFolio;
import model.Tracker;

public class TrackerTest {


	@Test
	public void testAddFolio() {
		Tracker t1 = new Tracker();
		IFolio Folio = new Folio("test");
		ArrayList<IFolio> Folios = t1.getFolios();
		t1.newFolio(Folio, "test");
		assertTrue(Folios.contains("test"));
}
}
