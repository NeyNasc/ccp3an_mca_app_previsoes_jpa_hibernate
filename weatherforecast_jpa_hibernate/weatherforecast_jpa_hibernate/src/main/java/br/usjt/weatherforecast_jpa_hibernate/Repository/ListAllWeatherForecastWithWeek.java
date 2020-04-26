package br.usjt.weatherforecast_jpa_hibernate.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class ListAllWeatherForecastWithWeek {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from Weatherforecast");
		List<Weatherforecast> weatherforecasts = query.getResultList();
		
		for (Weatherforecast weather : weatherforecasts) {
			
			System.out.println(weather);
		}
		
		manager.close();
		JPAUtil.close();
	
	}
}
