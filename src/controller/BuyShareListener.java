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
			
			}
		}
		
		
	}}}
