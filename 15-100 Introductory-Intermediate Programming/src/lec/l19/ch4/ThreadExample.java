package lec.l19.ch4;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.util.Date;

public class ThreadExample extends Applet implements Runnable {

	Thread clockThread;
	TextField clockField;
	Date date;
	boolean running = true;

	public void init() {
		setLayout(new BorderLayout());
		clockField = new TextField();
		add(clockField, "Center");
		clockThread = new Thread(this);
		clockThread.start();
	}

	public void destroy() {
		running = false;
		clockThread = null;
	}

	@Override
	public void run() {
		while (running) {
			date = new Date();
			String time = date.getHours() + ":" + date.getMinutes() + ":"
					+ date.getSeconds();
			clockField.setText(time);

			try {
				clockThread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}
}
