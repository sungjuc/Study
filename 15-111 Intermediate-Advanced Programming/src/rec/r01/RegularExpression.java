package rec.r01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
		// General RegEx in Java
		Pattern simple = Pattern.compile("[a-z]*[^A-Z]*");
		Matcher match1 = simple.matcher("cat");
		Matcher match2 = simple.matcher("starFish");

		System.out.println(match1.matches());
		System.out.println(match2.matches());

		// Simple matching
		System.out.println(Pattern.matches("[a-z]*[^A-Z]*", "cat"));
	}

	/**
	 * RegEx that matches a name of up to 10 letters followed by a space and
	 * then a year.
	 * 
	 * @param target
	 * @return
	 */
	public static boolean checkUpto10LettersAndAYear(String target) {
		String regEx = "^[a-z|A-Z]{0,10} [0-9+][0-9+][0-9+][0-9+]$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher m = pattern.matcher(target);
		return m.matches();
	}

	/**
	 * RegEx that matches a phone number.
	 * 
	 * @param target
	 * @return
	 */
	public static boolean checkPhoneNumber(String target) {
		String regEx = "^[1-9]{1,3}-[0-9]{1,4}-[0-9]{2,4}-[0-9]{4}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher m = pattern.matcher(target);
		return m.matches();
	}
}
