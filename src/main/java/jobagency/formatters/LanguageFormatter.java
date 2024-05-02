package jobagency.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import jobagency.models.LanguageBean;

public class LanguageFormatter implements Formatter<LanguageBean>{

	@Override
	public String print(LanguageBean object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LanguageBean parse(String text, Locale locale) throws ParseException {
		LanguageBean language = new LanguageBean();
		int id=Integer.parseInt(text);
		language.setId(id);
		return language;
	}

}
