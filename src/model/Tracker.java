package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import view.IGUI;

public class Tracker extends Observable implements ITracker {

	private ArrayList<IFolio> folios = new ArrayList<IFolio>();
	private IFolio currentFolio;
	
	
	public ArrayList<IFolio> getFolios() {
		return this.folios;
	}
	public IFolio getCurrFolio(){
		return this.currentFolio;
	}

	public IFolio openFile(File fileName, IGUI gui) throws FileNotFoundException {
		return null;
	}

	public void saveFile(IFolio currentFolio, String folioName) {
		
	}

	public void newFolio(IFolio folio) {
		
		folios.add(folio);
		currentFolio = folio;
		System.out.println(folio.getFolioName());
		notifyObservers();
	}

	public void closeFolio(IFolio folio) {
		
		currentFolio = folios.get((folios.indexOf(currentFolio)));
		folios.remove(folio);

		notifyObservers();

	}

	public void refreshAllData() {
		for(IFolio f: folios){
			 f.refreshFolioData();
			}
	}

public void changeCurrFolio(int index){
	currentFolio = folios.get(index);
}

	
}

