package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.weatherforecast_jpa_hibernate.Model.City;

public class UpdateCity {
public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		City city = manager.find(City.class, 1L);
		
		city.setName("Tokyo");
		city.setLat(35.6894);
		city.setLongi(139.692);
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}
}
