package Model;

public interface IFolio {
	
	public String getFolioName();
	
	public boolean addStock(String tickerSym, int quantity, double price);
	
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice);
	
	public double calculateValue(String tickerSym);
	
	public void refreshFolio();
	
   }
