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
import model.ITracker;
import model.IStock;

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
		btnSellStock.addActionListener(new SellShareListener(this, tracker));
		topPanel.add(btnSellStock);
		btnSellStock.setPreferredSize(new Dimension(80, 25));	

		// Tabbed Pane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.addChangeListener(new TabChangeListener(this, tracker));
		tabbedPane.addTab("Welcome", null, null, null);

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
		fMOpen.addActionListener(new MenuListener(this, tracker, null));
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
		
		// Help Menu
		JMenuItem hMAbout = new JMenuItem("About Folio Tracker");
		pfMNew.setActionCommand("About");
		hMAbout.addActionListener(new MenuListener(this, tracker));
		helpMenu.add(hMAbout);
	}

	public void showNewFolioAlert() {

		JTextField portFolioName = new JTextField(20);
		JLabel portFolioNameLabel = new JLabel("Enter PortFolio Name:");
		JPanel portFolioPanel = new JPanel();

		portFolioPanel.setLayout(new BoxLayout(portFolioPanel, BoxLayout.Y_AXIS));

		portFolioName.setMaximumSize(new Dimension(1500, 20));

		portFolioPanel.add(portFolioNameLabel);
		portFolioPanel.add(portFolioName);

		int result = JOptionPane.showConfirmDialog(null, portFolioPanel, "Create New PortFolio",
				JOptionPane.OK_CANCEL_OPTION);

		String folioName = (portFolioName.getText());

		if (result == JOptionPane.CANCEL_OPTION) {
			return;
		}
		if (folioName.equals("")) {
			JLabel enterFilenameLabel = new JLabel("Portfolio Name cannot blank.");
			portFolioPanel.add(enterFilenameLabel);
			JOptionPane.showMessageDialog(null, "Error");
			showNewFolioAlert();

		} else {
			// Creates the tab and portfolio
			createPortfolioTab(folioName);
			IFolio folio = new Folio(folioName);
			((Observable) folio).addObserver(this);
			tracker.addFolio(folio);

		}
	}

	// CREATE NEW PORTFOLIO TAB
	public void createPortfolioTab(String PortfolioName) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ticker Symbol");
		model.addColumn("Number of Shares");
		model.addColumn("Price per Share ($)");
		model.addColumn("Holding Value ($)");
		model.addColumn("Change (%)");

		// MAKE TABLE NON EDITABLE
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			// Stops the cells from being edited individually
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setFillsViewportHeight(false);

		// ADD TABLE TO PANNEL
		scrollPane = new JScrollPane(table);

		tabbedPane.addTab(PortfolioName, null, scrollPane, null);

//		 REMOVE EMPTY INITIAL TAB
		if (tabbedPane.getTabCount() > 0 && tables.isEmpty()) {
			tabbedPane.removeTabAt(0);
		}
		
		tables.add(table);

	}

	// UPDATE SHARE DATA IN TABLE
	@Override
	public void update(Observable o, Object arg) {

		IFolio folio = (IFolio) o;
		// Ensures there is a table to modify
		if (this.tables.size() > 0) {
			DefaultTableModel tblModel = (DefaultTableModel) this.tables.get(this.getTabbedPane().getSelectedIndex())
					.getModel();

			// Clear the table
			tblModel.setRowCount(0);

			// Add entries for all the shares in the portfolio
			for (IStock s : folio.getShares()) {
				// Add a row to the table
				tblModel.addRow(new Object[] {
						s.getTicker(),
						s.getAmountOwned(),
						new DecimalFormat("0.00").format(s.getSharePrice()),
						new DecimalFormat("0.00").format(folio.getShare(s.getTicker()).getSharePrice() * s.getAmountOwned()),
						s.getChange()
						});

			}
			// Update the total value of the folio
			NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
			this.folioValue.setText(formatter.format(folio.getFolioValue()));
		}
	}
}