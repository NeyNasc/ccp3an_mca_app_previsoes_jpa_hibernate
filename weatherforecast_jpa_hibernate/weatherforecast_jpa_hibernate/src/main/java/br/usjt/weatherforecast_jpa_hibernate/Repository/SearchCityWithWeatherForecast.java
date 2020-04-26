package br.usjt.weatherforecast_jpa_hibernate.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.usjt.weatherforecast_jpa_hibernate.Model.City;
import br.usjt.weatherforecast_jpa_hibernate.Model.Weatherforecast;

public class SearchCityWithWeatherForecast {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		City city = manager.find(City.class, 1L);
		
		List<Weatherforecast> weatherforecasts = city.getWeatherforecasts();
		
		for(Weatherforecast w: weatherforecasts) {
			System.out.println(w);
		}
		manager.close();
		JPAUtil.close();
	}
}
