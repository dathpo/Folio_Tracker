package Model;

import java.util.ArrayList;

public class Folio implements IFolio {

	public String folioName;
	private ArrayList<Stock> Holdings;
	public void setHoldings(ArrayList value) {
		this.Holdings = value;
	}
	public ArrayList getHoldings() {
		return this.Holdings;
	}
	public Folio(String folioName) {
		ArrayList Holdings = new ArrayList<Stock>();
	}
	public String getFolioName() {
		return this.folioName;
	}
	public boolean addStock(String tickerSym, int quantity, double price) {
		Stock newStock = new Stock(tickerSym, quantity, price);
		Holdings.add(newStock);
		return true;
	}
	public boolean editHolding(String tickerSym, int newQuantity, double newPrice) {
		for (Stock s : Holdings) {
			if (s.getTickerSym() == tickerSym) {
				if (s.getQuantity() != newQuantity) {
					s.setQuantity(newQuantity);
				}
				if (s.getPrice() != newPrice) {
					s.setPrice(newPrice);
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
	public void refreshFolio(){
		for(Stock s : Holdings){
			s.refreshPrice();
		}
	}
}
