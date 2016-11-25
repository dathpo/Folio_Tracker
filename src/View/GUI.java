package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import Model.Folio;
import Model.IFolio;
import Model.ITracker;

@SuppressWarnings("serial")
public class GUI extends JFrame implements IGUI, Observer {
	int numTabs = 0;
	public JFrame frame;
	public JPanel contentPanel, tabPanel, sharesPanel;
	public JTabbedPane tabbedPane;
	public DefaultTableModel tableModel;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField tickerSText, shareNumberText;

	public GUI() {
		buildMainFrame();
		buildMenuBar(frame);
		buildPanels();
//		buildTable();
		buildTabs();
	}

	public void build() {

	}

	public void buildMainFrame() {
		frame = new JFrame("Folio Tracker");
		frame.setSize(700, 500);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
//		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void buildMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		JMenu portfolioMenu = new JMenu("Portfolio");
		JMenu optionsMenu = new JMenu("Options");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(portfolioMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);

		JMenuItem fMOpen = new JMenuItem("Open");
		JMenuItem fMSaveAs = new JMenuItem("Save As");
		JSeparator fMSeparator = new JSeparator();
		JMenuItem fMExit = new JMenuItem("Exit");
		fMOpen.addActionListener(null);
		fMSaveAs.addActionListener(null);
		fMExit.addActionListener(null);
		fileMenu.add(fMOpen);
		fileMenu.add(fMSaveAs);
		fileMenu.add(fMSeparator);
		fileMenu.add(fMExit);

		JMenuItem pfMNew = new JMenuItem("New");
		JMenuItem pfMClose = new JMenuItem("Close");
		JSeparator pfMSeparator = new JSeparator();
		JMenuItem pfMDelete = new JMenuItem("Delete");
		pfMNew.addActionListener(null);
		pfMClose.addActionListener(null);
		pfMDelete.addActionListener(null);
		portfolioMenu.add(pfMNew);
		portfolioMenu.add(pfMClose);
		portfolioMenu.add(pfMSeparator);
		portfolioMenu.add(pfMDelete);

		JMenuItem oMRefresh = new JMenuItem("Refresh Share Prices");
		oMRefresh.addActionListener(null);
		optionsMenu.add(oMRefresh);

		JMenuItem hMAbout = new JMenuItem("About Folio Tracker");
		hMAbout.addActionListener(null);
		helpMenu.add(hMAbout);
	}

	public void buildPanels() {
		contentPanel = new JPanel();
		frame.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		contentPanel.add(topPanel, BorderLayout.NORTH);

		JLabel tickerSLabel = new JLabel("Ticker Symbol:");
		topPanel.add(tickerSLabel);
		
		tickerSText = new JTextField();
		tickerSText.setColumns(8);
		topPanel.add(tickerSText);
		
		JLabel shareNumberLabel = new JLabel("Number of Shares:");
		topPanel.add(shareNumberLabel);
		
		shareNumberText = new JTextField();
		shareNumberText.setColumns(8);
		topPanel.add(shareNumberText);
		
		JButton buyButton = new JButton("Buy");
		JButton sellButton = new JButton("Sell");
		buyButton.addActionListener(null);
		sellButton.addActionListener(null);
		topPanel.add(buyButton);
		topPanel.add(sellButton);

		JPanel bottomPanel = new JPanel();
		contentPanel.add(bottomPanel, BorderLayout.SOUTH);
		JLabel totalPFValueLabel = new JLabel("Total Portfolio Value: $" + "totalPFValue");
		// totalPFValue = totalPFValueNumber;
		bottomPanel.add(totalPFValueLabel);

		frame.setVisible(true);
	}

	private void createButtons() {

		// contentPanel.add(topPanel, BorderLayout.CENTER);
	}
	
	public void buildTabs() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.addTab("A", table);
		tabbedPane.addTab("B", scrollPane);
		tabbedPane.addTab("C", scrollPane);
		tabbedPane.addTab("D", scrollPane);
		
		tabPanel = new JPanel();

		if(tabbedPane.getTabCount()==0) {
			//
		}

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		table.setEnabled(true);
		JPanel tablePanel = new JPanel();
		contentPanel.add(tablePanel);
		contentPanel.add(tabPanel);
//		tabPanel.add(new JScrollPane(table));

		tableModel.addColumn("#");
		tableModel.addColumn("Ticker Symbol");
		tableModel.addColumn("Stock Name");
		tableModel.addColumn("Number of Shares");
		tableModel.addColumn("Price per Share");
		tableModel.addColumn("Holding Value");
		tableModel.addColumn("Change (%)");
		tableModel.addColumn("Highest ($)");
		tableModel.addColumn("Lowest ($)");
		
		table.setVisible(true);
		tabbedPane.setVisible(true);
	}
	
	public void NewPFAlert() {

		JTextField newPFName = new JTextField(20);
		JLabel newPFLabel = new JLabel("Enter the Portfolio Name:");
		JPanel newPFPanel = new JPanel();

		newPFPanel.setLayout(new BoxLayout(newPFPanel, BoxLayout.Y_AXIS));

		newPFName.setMaximumSize(new Dimension(1500, 20));

		newPFPanel.add(newPFLabel);
		newPFPanel.add(newPFName);

		int result = JOptionPane.showConfirmDialog(null, newPFPanel, "Create a new Portfolio",
				JOptionPane.OK_CANCEL_OPTION);

		String pfName = (newPFName.getText());

		if (result == JOptionPane.CANCEL_OPTION) {
			return;
		}
		if (newPFName.equals("")) {
			JLabel enterFilenameLabel = new JLabel("Enter a correct name.");
			newPFPanel.add(enterFilenameLabel);
			JOptionPane.showMessageDialog(null, "Error");
			NewPFAlert();

		} else {
//			// Creates the tab and portfolio
//			
//			IFolio IFolio = new IFolio();
//			createPortfolioTab(folio.getFolioName());
//			IFolio.addObserver(this);
//			portfolioBag.addPortfolio(folio);

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}
