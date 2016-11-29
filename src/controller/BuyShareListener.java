package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ITracker;
import view.IGUI;

public class BuyShareListener implements ActionListener {

	public BuyShareListener(IGUI gui, ITracker t) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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