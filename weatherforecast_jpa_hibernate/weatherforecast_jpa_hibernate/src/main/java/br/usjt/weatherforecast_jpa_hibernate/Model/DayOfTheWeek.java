package br.usjt.weatherforecast_jpa_hibernate.Model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


public class DayOfTheWeek {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameDayOfTheWeek;
	
	@OneToOne(mappedBy = "dayOfTheWeek", cascade = CascadeType.ALL)
	private Weatherforecast weatherforecast;
	
	
	public String getNameDayOfTheWeek() {
		return nameDayOfTheWeek;
	}
	public void setNameDayOfTheWeek(String nameDayOfTheWeek) {
		this.nameDayOfTheWeek = nameDayOfTheWeek;
	}
	public Long getId() {
		return id;
	}

	public Weatherforecast getWeatherforecast() {
		return weatherforecast;
	}
	public void setWeatherforecast(Weatherforecast weatherforecast) {
		this.weatherforecast = weatherforecast;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayOfTheWeek other = (DayOfTheWeek) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DiaDaSemana (id=" + id + ", nomeDoDiaDaSemana=" + nameDayOfTheWeek + ")";
	}
	
	
	
}
