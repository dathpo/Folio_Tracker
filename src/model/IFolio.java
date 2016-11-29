package model;

import java.util.ArrayList;

public interface IFolio {
	
	public String getFolioName();
	
	public void addStock(IStock stock);
	
	public boolean editHolding(String tickerSym, int newQuantity);
	
	public double calculateValue();
	
	public ArrayList<IStock> getStocks();
	
	void refreshFolioData();
	
	void sellShares(String tickerSym, int numSold);
	
	public double getTotalValue();

   }
