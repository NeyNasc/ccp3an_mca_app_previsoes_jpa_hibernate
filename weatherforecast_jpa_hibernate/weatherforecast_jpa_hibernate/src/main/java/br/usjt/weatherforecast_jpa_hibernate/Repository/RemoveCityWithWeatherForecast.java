package br.usjt.weatherforecast_jpa_hibernate.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.weatherforecast_jpa_hibernate.Model.City;
import br.usjt.weatherforecast_jpa_hibernate.Model.DayOfTheWeek;
import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class RemoveCityWithWeatherForecast {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		City city  = manager.find(City.class, 1L);
		
		List<Weatherforecast> weatherforecasts = city.getWeatherforecasts();
		
		for(Weatherforecast w: weatherforecasts) {
			
			DayOfTheWeek dayOfTheWeek = manager.find(DayOfTheWeek.class, w.getDayOfTheWeek().getId());
			manager.remove(w);
			manager.remove(dayOfTheWeek);
			
		}
					
		manager.remove(city);
		
		transaction.commit();
		manager.close();
		JPAUtil.close();				
	}
}