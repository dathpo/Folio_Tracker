package model;

import java.util.ArrayList;
import java.util.Observable;

public class Folio extends Observable implements IFolio  {

	public String folioName;
	private ArrayList<Stock> Holdings;
	
	public void setHoldings(ArrayList value) {
		this.Holdings = value;
		notifyObservers();
	}
	public ArrayList<Stock> getHoldings() {
		return this.Holdings;
	}
	public Folio(String folioName) {
		this.folioName = folioName;
		ArrayList<Stock> Holdings = new ArrayList<Stock>();
		notifyObservers();
	}
	public String getFolioName() {
		return this.folioName;
	}
	public boolean addStock(String tickerSym, int quantity) {
		Stock newStock = new Stock(tickerSym, quantity);
		Holdings.add(newStock);
		notifyObservers();
		return true;
	}
	@Override
	public String toString(){
		return folioName;
	}
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice) {
		for (Stock s : Holdings) {
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
		for (Stock s : Holdings) {
			if (s.getTickerSym() == tickerSym) {
				double p = s.getPrice();
				int q = s.getQuantity();
				return p * q;
			}
		}
		return 0;
	}
	
	public void refreshFolioData() {
		for(Stock s : Holdings){
			s.refreshPrice();
			notifyObservers();

		}
	}
	
	   
	   public void addStock(String folioName, String tickerSym, int quantity,  double price) {
		   	this.addStock(tickerSym, quantity); 
	   }
	   
	   public void editHolding(String folioName,String tickerSym, int newQuantity, double newPrice) {
		   this.editHolding(tickerSym, newQuantity, newPrice); 	
	   }
	   

		
	}

