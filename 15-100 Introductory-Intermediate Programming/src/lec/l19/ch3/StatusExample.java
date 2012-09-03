package lec.l19.ch3;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusExample extends Applet implements ActionListener {

	TextField statusField;
	Button statusButton;

	public void init() {
		setLayout(new FlowLayout());
		statusButton = new Button("Set Status");
		statusField = new TextField("Type here");

		statusButton.addActionListener(this);
		statusField.addActionListener(this);

		add(statusButton);
		add(statusField);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if (act.getSource() == statusButton)
			getAppletContext().showStatus(
					statusField.getText() + "(With ButtonAction");
		else
			getAppletContext().showStatus(
					statusField.getText() + "With FieldAction");

	}

}
