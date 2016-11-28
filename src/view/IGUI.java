package view;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IGUI {
	
	public ArrayList<JTable> getTables();
	
	public JTextField getTickerSText();
	
	public JTextField getShareNumberText();
	
	public JTabbedPane getTabbedPane();
	
	public JLabel getFolioValue();

	public void showNewFolioAlert();
	
	public void createPortfolioTab(String PortfolioName);
	
	public void update(Observable o, Object arg);
	
}
