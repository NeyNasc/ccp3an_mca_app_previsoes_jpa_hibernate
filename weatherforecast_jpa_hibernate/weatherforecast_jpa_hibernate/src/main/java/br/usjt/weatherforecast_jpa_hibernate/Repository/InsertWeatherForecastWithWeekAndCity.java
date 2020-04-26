package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.weatherforecast_jpa_hibernate.ConverteStringForDate;
import br.usjt.weatherforecast_jpa_hibernate.Model.City;
import br.usjt.weatherforecast_jpa_hibernate.Model.DayOfTheWeek;
import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class InsertWeatherForecastWithWeekAndCity {
	
public static void main (String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		
		DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
		dayOfTheWeek.setNameDayOfTheWeek("Domingo");
		manager.persist(dayOfTheWeek);
		
		DayOfTheWeek dayOfTheWeek1 = new DayOfTheWeek();
		dayOfTheWeek1.setNameDayOfTheWeek("Domingo");
		manager.persist(dayOfTheWeek1);
		
		City city = new City();
		city.setName("Sao Paulo");
		city.setLat(-23.5475);
		city.setLongi(-46.63611);
		manager.persist(city);
		
		Weatherforecast weatherforecast = new Weatherforecast();
		weatherforecast.setDescription("Sol com algumas nuvens. Não chove");
		weatherforecast.setMinimumTemperature(13.0);
		weatherforecast.setMaximumTemperature(25.0);
		weatherforecast.setUnity(81);
		
		ConverteStringForDate convData = new ConverteStringForDate();
		weatherforecast.setDateAndHouer(convData.convertDate("12/04/2020 12:30"));
		
		weatherforecast.setCity(city);
		weatherforecast.setDayOfTheWeek(dayOfTheWeek);
		
		Weatherforecast weatherforecast2 = new Weatherforecast();
		weatherforecast2.setDescription("Sol com algumas nuvens. Não chove");
		weatherforecast2.setMinimumTemperature(16.0);
		weatherforecast2.setMaximumTemperature(25.0);
		weatherforecast2.setUnity(70);
		
		ConverteStringForDate convData2 = new ConverteStringForDate();
		weatherforecast2.setDateAndHouer(convData2.convertDate("12/04/2020 20:40"));
		
		weatherforecast2.setCity(city);
		weatherforecast2.setDayOfTheWeek(dayOfTheWeek1);
		
		manager.persist(weatherforecast);
		manager.persist(weatherforecast2);
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
		
	}

}
