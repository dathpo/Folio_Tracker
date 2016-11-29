package model;

import java.util.ArrayList;
import java.util.Observable;

public class Folio extends Observable implements IFolio {
	
	public IStock stock;
	public String folioName;
	private double newPrice;
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
	

	public void addStock(IStock stock) {
		stocks.add(stock);
		setChanged();
		notifyObservers();

	}
	@Override
	public String toString(){
		return folioName;
	}
	public boolean editHolding(String tickerSym, int newQuantity) {
		for (IStock s : stocks) {
			if (s.getTickerSym().equals(tickerSym) ) {
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
	
	public double calculateValue(IFolio folio) {
		double folioValue = 0;
		for (IStock s : stocks) {
				double p = s.getPrice();
				int q = s.getQuantity();
				double stockValue = p * q;
				folioValue = folioValue + stockValue;
		}
		return folioValue;
	}
	
	public void refreshFolioData() {
		for(IStock s : stocks){
			s.refreshPrice();
			notifyObservers();

		}
	}
	@Override
	public void sellShares(String tickerSym, int numSold) {
		System.out.println("SellShares");
		for (IStock s: stocks){
			System.out.println("tickerSym"+tickerSym+ "s.gettickerSym"+s.getTickerSym());
			if (tickerSym.equals(s.getTickerSym())){
				System.out.println(s.getQuantity());
				s.setQuantity(s.getQuantity()- numSold);
			}
		}
		
	}
	
	   
//	   public void addStock(String folioName, String tickerSym, int quantity,  double price) {
//		   	this.addStock(tickerSym, quantity); 
//	   }
	
	   

		
	}

