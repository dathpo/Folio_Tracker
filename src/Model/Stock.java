package model;

import quote.Quote;

public class Stock implements IStock {

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
		if (price > highestPrice) {
			highestPrice = price;
		}

		if (price < lowestPrice) {
			lowestPrice = price;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean equals(Stock obj){
		boolean result = false;
		if(obj instanceof Stock)
		      result = (this.getStockName() == obj.getStockName());
		    return result;
		  }
	}
