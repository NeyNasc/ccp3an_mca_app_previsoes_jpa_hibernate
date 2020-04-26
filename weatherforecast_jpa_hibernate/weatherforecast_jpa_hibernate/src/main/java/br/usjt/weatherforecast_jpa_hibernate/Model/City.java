package br.usjt.weatherforecast_jpa_hibernate.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double lat;
	private Double longi;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<Weatherforecast> Weatherforecasts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongi() {
		return longi;
	}

	public void setLongi(Double longi) {
		this.longi = longi;
	}

	public List<Weatherforecast> getWeatherforecasts() {
		return Weatherforecasts;
	}

	public void setWeatherforecasts(List<Weatherforecast> weatherforecasts) {
		Weatherforecasts = weatherforecasts;
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
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "City (Id: " + id + ", Name:" + name + ", Latitude:" + lat+ ", Longitude=" + longi + ")";
	}	
	
}
