package Model;

public interface ITracker {

	 public void addFolio(String Name);
	 
	 public void deleteFolio(String Name);
	 
	 public void addStock(String folioName, String tickerSym, int quantity,  double price);
	 
	 public void editHolding(String folioName,String tickerSym, int newQuantity, double newPrice);
	 
	 public void refreshPrices();
	
   }
