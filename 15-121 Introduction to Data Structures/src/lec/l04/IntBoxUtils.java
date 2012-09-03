package lec.l04;

public class IntBoxUtils {
	public static void change(IntBox b, int newVal) {
		b = new IntBox(newVal);
	}
	
	public static void newChange(IntBox b, int newVal) {
		b.setValue(newVal);
	}
}
