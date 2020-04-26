package br.usjt.weatherforecast_jpa_hibernate.Repository;

import javax.persistence.Persistence;

public class CreateBaseAndTables {
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("usjtPU");
		
	}
}
