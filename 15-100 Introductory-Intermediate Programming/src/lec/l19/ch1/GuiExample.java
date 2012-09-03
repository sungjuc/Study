package lec.l19.ch1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.TextField;

public class GuiExample extends Applet {
	Button okButton;
	TextField nameField;
	CheckboxGroup radioGroup;
	Checkbox radio1;
	Checkbox radio2;
	Checkbox option;

	public void init() {
		setLayout(null);
		okButton = new Button("A Button");
		nameField = new TextField("A TextField", 100);
		radioGroup = new CheckboxGroup();
		radio1 = new Checkbox("Radio1", radioGroup, false);
		radio2 = new Checkbox("Radio2", radioGroup, true);
		option = new Checkbox("Option", false);

		okButton.setBounds(20, 20, 100, 30);
		nameField.setBounds(20, 70, 100, 40);
		radio1.setBounds(20, 120, 100, 30);
		radio2.setBounds(140, 120, 100, 30);
		option.setBounds(20, 170, 100, 30);

		add(okButton);
		add(nameField);
		add(radio1);
		add(radio2);
		add(option);

	}

}
