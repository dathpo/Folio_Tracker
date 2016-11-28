package view;

import model.ITracker;
import model.Tracker;

public class Main {

	public static void main(String[] args) {
		ITracker tracker = new Tracker();
		new GUI(tracker);
	}
}
