package model_;

public interface IStock {
	
	public void setTickerSym(String value);
	
	public String getTickerSym();
	
	public void setQuantity(int value);
	
	public int getQuantity();
	
	public void setStockName(String value);
	
	public String getStockName();
	
	public void setPrice(double value);
	
	public double getPrice();
	
	public void refreshPrice();
	
   }
