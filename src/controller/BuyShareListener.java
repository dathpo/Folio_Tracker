package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IStock;
import model.ITracker;
import model.Stock;
import view.IGUI;

public class BuyShareListener implements ActionListener {
	private IGUI gui;
	private ITracker track;
	public BuyShareListener(IGUI gui, ITracker t) {
		this.gui = gui;
		this.track = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("Buy")){
			String  ticker = gui.getTickerSText().getText();
			int numShares = Integer.parseInt(gui.getShareNumberText().getText());
			if(track.getCurrFolio().getStocks().contains(ticker)){
				int indexStock = track.getCurrFolio().getStocks().indexOf(ticker);
				track.getCurrFolio().getStocks().get(indexStock).setQuantity(numShares);
			}else{
				IStock newStock = new Stock(ticker, numShares);
				track.getCurrFolio().addStock(newStock);
			}
		}
	
	if (e.getActionCommand().equals("Sell")){
		String  ticker = gui.getTickerSText().getText();
		int numShares = Integer.parseInt(gui.getShareNumberText().getText());
		numShares= numShares*(-1);
		for(IStock s : track.getCurrFolio().getStocks()){
		System.out.println("Stock s"+ticker+s.toString());
			if (s.getTickerSym().equals(ticker)){
				s.setQuantity(numShares);
				System.out.println("number of shares"+numShares);
			}
		}
		System.out.println("Sold "+ track.getCurrFolio().getStocks().get(0).getQuantity());
		
	}

}
}
/*
public class AddTickerListener implements ActionListener {

   	private MainClass myview;
	private IPortfolioOpr mybag;

	public AddTickerListener(MainClass myview, IPortfolioOpr mybag) {
		this.myview = myview;
		this.mybag = mybag;
	}
  @Override
    public void actionPerformed(ActionEvent e) {

		if (!mybag.getPortfolios().isEmpty()) {
			MyPortfolio portfolio = mybag.getPortfolios().get(myview.getPflPannel().getSelectedIndex());

			try {
				String ticker = myview.getFtxtTickerSymbol().getText();
				if (ticker.length() == 0) {
					throw new Exception("Ticker has no data");
				}
				ticker = ticker.toUpperCase();
				int amount = Integer.parseInt(myview.getFtxtQuantity().getText());
				if (amount < 1) {
					throw new Exception("Can't buy less than one");
				}

				// ADD A STOCK TO THE PORTFOLIO
				portfolio.addShare(ticker, amount);

			}
			catch (Exception exc) {
				PortfolioAlerts.showErrorAlert(exc.getMessage());
				System.out.println("Invalid entry");
			}
		}
		else {
			// NO TABS
			PortfolioAlerts.showNoOpenFolioAlert();
		}


    }
}*/