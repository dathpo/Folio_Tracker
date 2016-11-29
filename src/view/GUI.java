package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BuyShareListener;
import controller.MenuListener;
import controller.SellShareListener;
import controller.TabChangeListener;
import model.Folio;
import model.IFolio;
import model.IStock;
import model.ITracker;
import model.Stock;

public class GUI implements IGUI, Observer {

	private ITracker tracker;
	private JFrame frame;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane;
	private ArrayList<JTable> tables;
	private JScrollPane scrollPane;
	private JLabel folioValue;
	private JTextField tickerSText;
	private JTextField shareNumberText;
	private DefaultTableModel model;

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public ArrayList<JTable> getTables() {
		return tables;
	}

	public JTextField getTickerSText() {
		return tickerSText;
	}

	public JTextField getShareNumberText() {
		return shareNumberText;
	}


	public JLabel getFolioValue() {
		return folioValue;
	}
	
	public GUI(ITracker t) {
		this.tracker = t;
		buildMainFrame();
	}

	private void buildMainFrame() {

		// Frame
		frame = new JFrame("Folio Tracker");
		frame.setResizable(false);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tables = new ArrayList<JTable>();

		// Buy Share Ticker Label
		contentPanel = new JPanel();
		frame.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		// Top Panel
		JPanel topPanel = new JPanel();
		contentPanel.add(topPanel, BorderLayout.NORTH);
		
		// Ticker Symbol label
		JLabel tickerSLabel = new JLabel("Ticker Symbol:");
		topPanel.add(tickerSLabel);

		// Ticker Symbol text field
		tickerSText = new JTextField();
		tickerSText.setPreferredSize(new Dimension(90, 25));
		topPanel.add(tickerSText);

		// Number of Shares label
		JLabel lblQty = new JLabel("Number of Shares:");
		topPanel.add(lblQty);

		// Number of Shares text field
		shareNumberText = new JTextField();
		shareNumberText.setPreferredSize(new Dimension(80, 25));
		topPanel.add(shareNumberText);
		
		// Buy Share Button
		JButton btnAddStock = new JButton("Buy");
		topPanel.add(btnAddStock);
		btnAddStock.addActionListener(new BuyShareListener(this, tracker));
		btnAddStock.setPreferredSize(new Dimension(80, 25));
		
		// Sell Share Button
		JButton btnSellStock = new JButton("Sell");
		btnSellStock.addActionListener(new BuyShareListener(this, tracker));
		topPanel.add(btnSellStock);
		btnSellStock.setPreferredSize(new Dimension(80, 25));	

		// Tabbed Pane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.addChangeListener(new TabChangeListener(this, tracker));
		tabbedPane.addTab("Please create or open a portfolio", null, null, null);

		// Bottom Panel
		JPanel bottomPanel = new JPanel();
		contentPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		// Portfolio Value label
		JLabel folioValueLabel = new JLabel("Total Portfolio Value:");
		bottomPanel.add(folioValueLabel);

		// Portfolio Value
		folioValue = new JLabel("");
		bottomPanel.add(folioValue);
		
		this.buildMenu(frame);

		// Make the whole thing Visible!
		frame.setVisible(true);

	}

	private void buildMenu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// Menus
		JMenu fileMenu = new JMenu("File");
		JMenu portfolioMenu = new JMenu("Portfolio");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(portfolioMenu);
		menuBar.add(helpMenu);
		
		// File Menu Items
		JMenuItem fMOpen = new JMenuItem("Open");
		JMenuItem fMSave = new JMenuItem("Save");
		JSeparator fMSeparator = new JSeparator();
		JMenuItem fMExit = new JMenuItem("Exit");
		fMOpen.setActionCommand("OpenFile");
		fMSave.setActionCommand("SaveFile");
		fMExit.setActionCommand("Exit");
		fMOpen.addActionListener(new MenuListener(this, tracker));
		fMSave.addActionListener(new MenuListener(this, tracker));
		fMExit.addActionListener(new MenuListener(this, tracker));
		fileMenu.add(fMOpen);
		fileMenu.add(fMSave);
		fileMenu.add(fMSeparator);
		fileMenu.add(fMExit);
		
		// Portfolio Menu
		JMenuItem pfMNew = new JMenuItem("New");
		JMenuItem pfMRefresh = new JMenuItem("Refresh");
		JSeparator pfMSeparator = new JSeparator();
		JMenuItem pfMClose = new JMenuItem("Close");
		pfMNew.setActionCommand("NewFolio");
		pfMRefresh.setActionCommand("RefreshFolio");
		pfMClose.setActionCommand("CloseFolio");
		pfMNew.addActionListener(new MenuListener(this, tracker));
		pfMRefresh.addActionListener(new MenuListener(this, tracker));
		pfMClose.addActionListener(new MenuListener(this, tracker));
		portfolioMenu.add(pfMNew);
		portfolioMenu.add(pfMRefresh);
		portfolioMenu.add(pfMSeparator);
		portfolioMenu.add(pfMClose);
	}

	public String newFolioAlert() {

		JTextField portFolioName = new JTextField(20);
		JLabel portFolioNameLabel = new JLabel("Enter Portfolio Name:");
		JPanel portFolioPanel = new JPanel();

		portFolioPanel.setLayout(new BoxLayout(portFolioPanel, BoxLayout.Y_AXIS));

		portFolioName.setMaximumSize(new Dimension(1500, 20));

		portFolioPanel.add(portFolioNameLabel);
		portFolioPanel.add(portFolioName);

		String folioName = "";
		int result = 1; // 1 = NO
		do {
			result = JOptionPane.showConfirmDialog(null, portFolioPanel, "Create a New Portfolio",
					JOptionPane.OK_OPTION);
			folioName = portFolioName.getText();

		} while (folioName.equals("") && result == 0);

		if (result == 0)
			newTab(folioName);
		return folioName;
	}


	// CREATE NEW PORTFOLIO TAB
	public void newTab(String PortfolioName) {
		model = new DefaultTableModel();
		model.addColumn("Ticker Symbol");
		model.addColumn("Number of Shares");
		model.addColumn("Price per Share ($)");
		model.addColumn("Holding Value ($)");
		model.addColumn("Change (%)");

		// String[] socrates = {"a", "", "469-399 B.C." };
		// model.addRow(socrates);

		// MAKE TABLE NON EDITABLE
		JTable table = new JTable(model) {

			// Stops the cells from being edited individually
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setFillsViewportHeight(false);

		// ADD TABLE TO PANNEL
		scrollPane = new JScrollPane(table);

		tabbedPane.addTab(PortfolioName, null, scrollPane, null);

		// REMOVE EMPTY INITIAL TAB
		if (tabbedPane.getTabCount() > 0 && tables.isEmpty()) {
			tabbedPane.removeTabAt(0);
		}
		tables.add(table);
	}
	

	// UPDATE SHARE DATA IN TABLe
	public void update(Observable obs, Object arg) {
		if (obs instanceof Folio) {
			System.out.println("obs instanceof Folio");
			IFolio folio = (IFolio) obs;
			folio.refreshFolioData();
			Object[] row = { "", "469-399 B.C." };
			model.addRow(row);

			// check that there is a table to modify
			if (this.tables.size() > 0) {
				// put selected table into a defaulttablemodel to clear it
				model = (DefaultTableModel) this.tables.get(this.getTabbedPane().getSelectedIndex()).getModel();

				for (IStock s : folio.getStocks()) {
					double change = ((s.getLast() - s.getPrice()) / s.getLast()) * 100;
					model.insertRow(0, new Object[] { s.getTickerSym(), s.getQuantity(), s.getPrice(),
							s.calculateValue(), change });
				}
			}
		} else if (obs instanceof ITracker) {
			System.out.println("obs instanceof ITracker");
		}
	}

}

















