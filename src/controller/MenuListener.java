package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import model.IFolio;
import model.ITracker;
import view.IGUI;

public class MenuListener implements ActionListener {

	private IGUI gui;
	private ITracker tracker;

	public MenuListener(IGUI gui, ITracker tracker){
		this.gui = gui;
		this.tracker = tracker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OpenFile")) {
			File fileName = null;
			try {
				tracker.openFile(fileName, gui);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		else if(e.getActionCommand().equals("SaveFile")) {
			IFolio currentFolio = null;
			String folioName = null;
			tracker.saveFile(currentFolio, folioName);
		}
		
		else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
		else if(e.getActionCommand().equals("NewFolio")) {
			IFolio folio = null;
			tracker.newFolio(folio, null);
		}

		else if(e.getActionCommand().equals("RefreshData")) {
			tracker.refreshAllData();
		}

		else if(e.getActionCommand().equals("CloseFolio"))
		{
			IFolio folio = null;
			tracker.closeFolio(folio);
		}
	}
}

		

