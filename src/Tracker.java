import java.util.*;

public class Tracker {
private ArrayList<Folio> Folios = new ArrayList<Folio>();
   
   public void setFolios(ArrayList value) {
      this.Folios = value;
   }
   
   public ArrayList getFolios() {
      return this.Folios;
   }
   
   
   public void addFolio(String Name) {
	  Folio newFolio = new Folio(Name);
      Folios.add(newFolio);
   }
   
   public void deleteFolio(String Name) {
      for(Folio f: Folios){
    	  if(f.getName()==Name){
    		  Folios.remove(f);
    	  }
      }
   }
   
   public void addStock(String folioName, String tickerSym, int quantity,  double price) {
	   for(Folio f: Folios){
	    	  if(f.getName()==folioName){
	    		 f.addStock(tickerSym, quantity, price);
	    	  }
	      }
   }
   
   public void editHolding(String folioName,String tickerSym, int newQuantity, double newPrice) {
	   for(Folio f: Folios){
	    	  if(f.getName()==folioName){
	    		 f.editHolding(tickerSym, newQuantity, newPrice);
	    	  }
	      }
   }
   
   public void refreshPrices() {
	   for(Folio f: Folios){
	    	 	f.refreshFolio();
	      }
   }
   
   }
