package model_;

import java.util.ArrayList;

public interface IFolio {
	
	public String getFolioName();
	
	public boolean addStock(String tickerSym, int quantity);
	
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice);
	
	public double calculateValue(String tickerSym);
	
	public void refreshData();
	
	public ArrayList getHoldings();
   }
