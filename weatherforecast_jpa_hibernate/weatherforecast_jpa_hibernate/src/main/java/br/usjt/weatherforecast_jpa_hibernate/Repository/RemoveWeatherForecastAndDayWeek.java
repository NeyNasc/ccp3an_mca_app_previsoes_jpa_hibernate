package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.weatherforecast_jpa_hibernate.Model.DayOfTheWeek;
import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class RemoveWeatherForecastAndDayWeek {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Weatherforecast weatherforecast = manager.find(Weatherforecast.class, 1L);
		DayOfTheWeek dayOfTheWeek = manager.find(DayOfTheWeek.class, weatherforecast.getDayOfTheWeek().getId());
		
		manager.remove(weatherforecast);
		manager.remove(dayOfTheWeek);
		
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
