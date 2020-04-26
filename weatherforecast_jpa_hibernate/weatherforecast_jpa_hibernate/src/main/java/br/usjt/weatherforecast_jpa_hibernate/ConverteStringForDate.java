package br.usjt.weatherforecast_jpa_hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteStringForDate {
	public Date convertDate(String dataString) {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		Date data = null;
		try {
			data = formato.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
