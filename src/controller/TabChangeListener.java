package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ITracker;
import view.IGUI;

public class TabChangeListener implements ChangeListener {
	private IGUI gui;
	private ITracker track;
	public TabChangeListener(IGUI gui, ITracker t) {
		this.gui = gui;
		this.track = t;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if (!(track.getFolios().isEmpty())){
		track.changeCurrFolio(gui.getTabbedPane().getSelectedIndex());
		System.out.println("Tab changed to "+track.getCurrFolio());
	}
	}
}

