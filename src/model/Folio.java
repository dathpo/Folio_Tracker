package model;

import java.util.ArrayList;
import java.util.Observable;

public class Folio extends Observable implements IFolio {

    public IStock stock;
    public String folioName;
    private double newPrice;
    private ArrayList<IStock> stocks;
    private double portfolioVal;

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
    public String toString() {
        return folioName;
    }

    public boolean editHolding(String tickerSym, int newQuantity) {
        for (IStock s : stocks) {
            if (s.getTickerSym().equals(tickerSym)) {
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

    public double calculateValue() {
        for (IStock s : stocks) {
            double p = s.getPrice();
            int q = s.getQuantity();
            portfolioVal += p * q;
        }
        return portfolioVal;
    }

    public void refreshFolioData() {
        for (IStock s : stocks) {
            s.refreshPrice();
            notifyObservers();
        }
    }

    public double getTotalValue() {
        return portfolioVal;
    }

    @Override
    public void sellShares(String tickerSym, int numSold) {
        IStock stockRM = null;
        for (IStock s : stocks) {
            if (tickerSym.equals(s.getTickerSym())) {
                s.setQuantity(s.getQuantity() - numSold);
                System.out.println(s.getQuantity());
                if (s.getQuantity() <= 0) {
                    stocks.remove(s);
                }
            }
        }
    }
}

