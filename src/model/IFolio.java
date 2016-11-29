package model;

import java.util.ArrayList;

public interface IFolio {
	
	public String getFolioName();

	public void createStock(String tickerSym, int quantity);
	
	public IStock addStock(IStock stock);
	
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice);
	
	public double calculateValue(String tickerSym);
	
	public ArrayList<IStock> getStocks();
	
	void refreshFolioData();

   }
