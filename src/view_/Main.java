package view_;

import model_.ITracker;
import model_.Tracker;

public class Main {

	public static void main(String[] args) {
		ITracker tracker = new Tracker();
		new GUI(tracker);
	}
}
