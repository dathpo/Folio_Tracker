package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			tracker.refreshData();
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
