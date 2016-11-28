package model_;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import view_.IGUI;

public interface ITracker {
	
	ArrayList<IFolio> getFolios();

	IFolio openFile(File fileName, IGUI gui) throws FileNotFoundException;

	void saveFile(IFolio currentFolio, String folioName);

	void newFolio(IFolio folio, String folioName);

	void closeFolio(IFolio folio);
}
