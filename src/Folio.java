import java.util.*;
public class Folio {

   private Set<Stock> stock;
   
   
   public Set<Stock> getStock() {
      if (this.stock == null) {
         this.stock = new HashSet<Stock>();
      }
      return this.stock;
   }
   
   private ArrayList<Stock> Holdings;
   
   public void setHoldings(ArrayList value) {
      this.Holdings = value;
   }
   
   public ArrayList getHoldings() {
      return this.Holdings;
   }
   
	
	
	public Folio(){ 
		ArrayList Holidings = new ArrayList<Stock>(); 
	}
	
	
	
   public boolean addStock(String tickerSym, String stockName, int quantity, double price) {
 
Stock newStock = new Stock(tickerSym, stockName, quantity, price);
		Holdings.add(newStock);
		return true;

   
   }
   
   public boolean editHolding(String tickerSym, int newQuantity, double newPrice) {
      
	   for(Stock s: Holdings){
		   if (s.getTickerSym()==tickerSym){
			   if (s.getQuantity()!=newQuantity){
				   s.setQuantity(newQuantity);
		   }
			   if (s.getPrice()!=newPrice){
				   s.setPrice(newPrice);
		   }
			   
		   }
	   
	   }
	   return true;
   }
   
   public double calculateValue(String tickerSym) {
	   for(Stock s: Holdings){
		   if (s.getTickerSym()==tickerSym){
			  double p= s.getPrice();
			   int q = s.getQuantity();
			   return p*q;
		   }
		   
		   }
	   return 0;
	   }
	 
   }
   
   
