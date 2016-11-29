package model;

import quote.Quote;
import java.util.Observable;

public class Stock extends Observable implements IStock {

	private double highestPrice;
	private double lowestPrice;
	private double price;
	private String stockName;
	private String tickerSym;
	private int quantity;
	private double lastPrice;

	public Stock(String tickerSym, int quantity) {
		this.tickerSym = tickerSym;
		this.quantity = quantity;
		Quote q = new Quote(false);
			try{
				lastPrice = this.getPrice();
				q.setValues(tickerSym);
				setPrice(q.getLatest());
				}catch(Exception e){
					e.printStackTrace();
				}
	}

	private double getHighest() {
		return highestPrice;
	}

	private double getLowest() {
		return lowestPrice;
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
	public double getLast(){
		return this.lastPrice;
	}

	public void setPrice(double value) {
		this.lastPrice = this.price; 
		this.price = value;
		if (price > highestPrice) {
			highestPrice = price;
			notifyObservers();

		}

		if (price < lowestPrice) {
			lowestPrice = price;
			notifyObservers();

		}
	}

	public double getPrice() {
		return this.price;
	}

	public void refreshPrice() {
		Quote q = new Quote(false);
		try {
			lastPrice = this.getPrice();
			q.setValues(tickerSym);
			setPrice(q.getLatest());
			notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double calculateValue() {
		return this.getQuantity() * this.getPrice();
	}
	public boolean equals(Stock obj){
		boolean result = false;
		if(obj instanceof Stock)
		      result = (this.getTickerSym() == obj.getTickerSym());
		    return result;
		  }
	}
