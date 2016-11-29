package model;

import java.util.ArrayList;
import java.util.Observable;

public class Folio extends Observable implements IFolio {
	
	public IStock stock;
	public String folioName;
	private ArrayList<IStock> stocks;
	
	public ArrayList<IStock> getStocks() {
		return this.stocks;
	}
	public Folio(String folioName) {
		this.folioName = folioName;
		stocks = new ArrayList<IStock>();
		setChanged();
		notifyObservers();
	}
	public String getFolioName() {
		return this.folioName;
	}
	
	public void createStock(String tickerSym, int quantity) {
		stock = new Stock(tickerSym, quantity);
	}
	
	public IStock addStock(IStock stock) {
		stocks.add(stock);
		setChanged();
		notifyObservers();
		return stock;
	}
	@Override
	public String toString(){
		return folioName;
	}
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice) {
		for (IStock s : stocks) {
			if (s.getTickerSym() == tickerSym) {
				if (s.getQuantity() != newQuantity) {
					s.setQuantity(newQuantity);
					notifyObservers();

				}
				if (s.getPrice() != newPrice) {
					s.setPrice(newPrice);
					notifyObservers();

				}
			}
		}
		
		return true;
	}
	
	public double calculateValue(String tickerSym) {
		for (IStock s : stocks) {
			if (s.getTickerSym() == tickerSym) {
				double p = s.getPrice();
				int q = s.getQuantity();
				return p * q;
			}
		}
		return 0;
	}
	
	public void refreshFolioData() {
		for(IStock s : stocks){
			s.refreshPrice();
			notifyObservers();

		}
	}
	
	   
//	   public void addStock(String folioName, String tickerSym, int quantity,  double price) {
//		   	this.addStock(tickerSym, quantity); 
//	   }
	   
	   public void editHolding(String folioName,String tickerSym, int newQuantity, double newPrice) {
		   this.editHolding(tickerSym, newQuantity, newPrice); 	
	   }
	   

		
	}

