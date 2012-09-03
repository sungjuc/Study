package lec.l19.ch3;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ShowDocumentExample extends Applet implements ActionListener {

	TextField urlField;
	Button goButton;

	boolean UrlOnError;
	URL userUrl;

	public void init() {
		setLayout(new FlowLayout());
		urlField = new TextField("RealApplets.com");
		goButton = new Button("Go!");

		urlField.addActionListener(this);
		goButton.addActionListener(this);

		add(urlField);
		add(goButton);
	}

	public void paint(Graphics g) {
		if (!UrlOnError)
			g.drawString("Type your URL and click go!", 20, 80);
		else {
			g.drawString("Malformed URL: " + userUrl, 20, 80);
			g.drawString("This Applet only allows .com domain", 20, 100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		UrlOnError = false;
		String temp = urlField.getText();

		if (temp.length() > 6) {
			if (!temp.substring(0, 7).toUpperCase().equals(("HTTP://")))
				temp = "http://" + temp;
		} else
			temp = "http://" + temp;

		if (temp.indexOf(".com") == -1)
			UrlOnError = true;

		try {
			userUrl = new URL(temp);
		} catch (Exception e) {
			UrlOnError = true;
		}

		urlField.setText(userUrl.toString());

		if (!UrlOnError)
			getAppletContext().showDocument(userUrl, "_blank");

		repaint();
	}

}
