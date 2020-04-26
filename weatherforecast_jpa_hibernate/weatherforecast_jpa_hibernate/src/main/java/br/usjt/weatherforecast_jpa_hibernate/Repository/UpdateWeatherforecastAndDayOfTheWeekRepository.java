package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.weatherforecast_jpa_hibernate.ConverteStringForDate;
import br.usjt.weatherforecast_jpa_hibernate.Model.DayOfTheWeek;
import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class UpdateWeatherforecastAndDayOfTheWeekRepository {
	public static void main (String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		Weatherforecast weatherforecast = manager.find(Weatherforecast.class, 1L);
		weatherforecast.setDescription("Sol com muitas nuvens");
		weatherforecast.setMaximumTemperature(16.0);
		weatherforecast.setMaximumTemperature(25.0);
		weatherforecast.setUnity(80);
		
		ConverteStringForDate dateConv = new ConverteStringForDate();
		weatherforecast.setDateAndHouer(dateConv.convertDate("12/04/2020 12:10"));
			
		DayOfTheWeek dayOfTheWeek = manager.find(DayOfTheWeek.class, weatherforecast.getDayOfTheWeek().getId());
		
		dayOfTheWeek.setNameDayOfTheWeek("Domingo");
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}
}