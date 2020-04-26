package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.EntityManager;

import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class SearchWeatherForecastWithWeekAndCity {
	
public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Weatherforecast weatherforecast = manager.find(Weatherforecast.class, 1L);
		
		System.out.println(weatherforecast);
		
		manager.close();
		JPAUtil.close();
		
	}
}