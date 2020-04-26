package br.usjt.weatherforecast_jpa_hibernate.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name= "tb_weatherforecast")
public class Weatherforecast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double minimumTemperature;
	private Double maximumTemperature;
	private Integer unity;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dateAndHouer;
	
	@OneToOne (optional = false)
	@JoinColumn (name = "id_dayoftheweek")
	private DayOfTheWeek dayOfTheWeek;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_city")
	private City city;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getMinimumTemperature() {
		return minimumTemperature;
	}
	public void setMinimumTemperature(Double minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}
	public Double getMaximumTemperature() {
		return maximumTemperature;
	}
	public void setMaximumTemperature(Double maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	public Integer getUnity() {
		return unity;
	}
	public void setUnity(Integer unity) {
		this.unity = unity;
	}
	public Date getDateAndHouer() {
		return dateAndHouer;
	}
	public void setDateAndHouer(Date dateAndHouer) {
		this.dateAndHouer = dateAndHouer;
	}
	public DayOfTheWeek getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
		Weatherforecast other = (Weatherforecast) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrevisaoTempo (id=" + id + ", descricao=" + description + ", tempMin=" + minimumTemperature + ", tempMax=" + maximumTemperature
				+ ", umidade=" + unity + ", dataHora=" + dateAndHouer + ", diaDaSemana=" + dayOfTheWeek + ", cidade="+ city + ")";
	}
	
}
