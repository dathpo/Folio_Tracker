package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import view.IGUI;

public class Tracker implements ITracker {

	private ArrayList<IFolio> folios = new ArrayList<IFolio>();

	public ArrayList<IFolio> getFolios() {
		return this.folios;
	}

	public IFolio openFile(File fileName, IGUI gui) throws FileNotFoundException {
		return null;
	}

	public void saveFile(IFolio currentFolio, String folioName) {

	}

	public void newFolio(IFolio folio, String folioName) {
		IFolio newFolio = new Folio(folioName);
		folios.add(newFolio);
	}

	public void closeFolio(IFolio folio) {
		folios.remove(folio);
	}

	public void refreshAllData() {
	}

	//		   public void setFolios(ArrayList value) {
		//	      this.folios = value;
	//	   }
	//		
	//	   public void addStock(String folioName, String tickerSym, int quantity,  double price) {
	//		   for(IFolio f: folios){
	//		    	  if(f.getFolioName()==folioName){
	//		    		 f.addStock(tickerSym, quantity);
	//		    	  }
	//		      }
	//	   }
	//	   
	//	   public void editHolding(String folioName,String tickerSym, int newQuantity, double newPrice) {
	//		   for(Folio f: folios){
	//		    	  if(f.getFolioName()==folioName){
	//		    		 f.editHolding(tickerSym, newQuantity, newPrice);
	//		    	  }
	//		      }
	//	   }
	//	   
	//	   public void refreshPrices() {
	//		   for(Folio f: folios){
	//		    	 	f.refreshFolio();
	//		      }
	//	   }


}
