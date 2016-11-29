package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Folio;
import model.IFolio;
import model.IStock;
import model.Stock;
import model.Tracker;

public class TrackerTest {


	@Test
	public void testAddFolio() {
		Tracker t1 = new Tracker();
		IFolio Folio = new Folio("test");
		ArrayList<IFolio> Folios = t1.getFolios();
		t1.newFolio(Folio);
		assertFalse(Folios.isEmpty());
}
	@Test
	public void testRemoveFolio(){
		Tracker t1 = new Tracker();
		IFolio Folio = new Folio("test");
		t1.newFolio(Folio);
		t1.closeFolio(Folio);
		ArrayList<IFolio> Folios = t1.getFolios();
		assertTrue(Folios.isEmpty());
	}
	
	@Test
	public void refreshFolioData(){
		Tracker t1 = new Tracker();
		IFolio Folio = new Folio("test");
		t1.newFolio(Folio);
		IStock stock = new Stock("GOOG", 1);
		Folio.addStock(stock);
		double amount = Folio.calculateValue();
		Folio.addStock(stock);
		Folio.refreshFolioData();
		double amount2 = Folio.calculateValue();
		assertTrue(amount2==(amount*2));

	}
}
