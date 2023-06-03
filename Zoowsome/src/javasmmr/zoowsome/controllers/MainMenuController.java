package javasmmr.zoowsome.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javasmmr.zoowsome.views.utilities.AddController;
import javasmmr.zoowsome.views.utilities.AddFrame;
import javasmmr.zoowsome.views.utilities.MainMenuFrame;

public class MainMenuController extends AbstractController {

	public MainMenuController(MainMenuFrame frame, boolean hasBackButton) {
		super(frame, hasBackButton);
		frame.setAddButtonActionListener(new AddButtonActionListener());
	}

	private class AddButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new AddController(new AddFrame("Add"), true);
		}
	}

}
