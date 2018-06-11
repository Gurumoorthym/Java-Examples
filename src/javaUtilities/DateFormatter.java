package javaUtilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {

	public static void main(String[] args) {
		System.out.println(formatDateInSentence("Today is 11-06-2018 and tomorrow is 12-06-2018"));
	}

	private static String formatDateInSentence(String string) {
		String date;
		Pattern pattern = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
		Matcher match = pattern.matcher(string);
		while(match.find()) {
		date = match.group();
		string = string.replaceAll(date, formatDate(date));
		}
		return string;
	}

	private static String formatDate(String date) {
		 String[] dateArray = date.split("-");
		 return dateArray[1]+"-"+dateArray[0]+"-"+dateArray[2];
	}

}
