import java.util.HashSet;
import java.util.Set;

public class Stock {
 private double highestPrice;
 private double lowestPrice;
 private double price;
 private String stockName;
 private String tickerSym;
 private int quantity;
 
 public Stock(String tickerSym, String stockName, int quantity, double price){
	 
	 this.tickerSym =tickerSym;
	 this.stockName = stockName;
	 this.quantity = quantity;
	 this.price = price;
 }
 
 
   private Set<Folio> folio;
   
   public Set<Folio> getFolio() {
      if (this.folio == null) {
         this.folio = new HashSet<Folio>();
      }
      return this.folio;
   }
   
 private double getHighest(){
	 return highestPrice;
 }
   
 private double getLowest(){	 
	 return lowestPrice;
 }
   

 
   private Set<IQuote> iQuote;
   
   public Set<IQuote> getIQuote() {
      if (this.iQuote == null) {
         this.iQuote = new HashSet<IQuote>();
      }
      return this.iQuote;
   }
   
  
   public void setTickerSym(String value) {
      this.tickerSym = value;
   }
   
   public String getTickerSym() {
      return this.tickerSym;
   }
   

   public void setQuantity(int value) {
      this.quantity = value;
   }
   
   public int getQuantity() {
      return this.quantity;
   }
   

   
   public void setStockName(String value) {
      this.stockName = value;
   }
   
   public String getStockName() {
      return this.stockName;
   }
   

   public void setPrice(double value) {
      this.price = value;
      if (price> highestPrice){
    	  highestPrice= price;
      }
      
      if (price< lowestPrice){
    	  lowestPrice= price;
      }
   }
   
   public double getPrice() {
      return this.price;
   }
   
   }
