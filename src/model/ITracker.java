package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import view.IGUI;

public interface ITracker {
	
	ArrayList<IFolio> getFolios();

	IFolio openFile(File fileName, IGUI gui) throws FileNotFoundException;

	void saveFile(IFolio currentFolio, String folioName);

	void newFolio(IFolio folio);

	void closeFolio(IFolio folio);

	void refreshAllData();
	IFolio getCurrFolio();
	void changeCurrFolio(int index);
}
