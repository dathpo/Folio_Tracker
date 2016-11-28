package controller_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUIInterface;
import model.IFolio;
import model.ITracker;
import view.IGUI;

public class MenuListener implements ActionListener {

	private IGUI gui;
	private ITracker tracker;
	private IFolio folio;

	public MenuListener(IGUI gui, ITracker tracker, IFolio folio){
		this.gui = gui;
		this.tracker = tracker;
		this.folio = folio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OpenFile")) {
			tracker.openFile();
		}

		else if(e.getActionCommand().equals("SaveFile")) {
			tracker.saveFile();
		}
		
		else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
		else if(e.getActionCommand().equals("NewFolio")) {
			tracker.newFolio();
		}

		else if(e.getActionCommand().equals("RefreshData")) {
			folio.refreshData();
		}

		else if(e.getActionCommand().equals("CloseFolio"))
		{
			tracker.closeFolio();
		}

		else if(e.getActionCommand().equals("About"))
		{
			gui.about();
	}	
}
