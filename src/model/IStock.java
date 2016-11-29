package model;

public interface IStock {
	
	
	public String getTickerSym();
	
	public void setQuantity(int value);
	
	public int getQuantity();
	
	public void setPrice(double value);
	
	public double getPrice();
	
	public void refreshPrice();
	public double getLast();

	public double calculateValue();
   }
