package ru.online76.arm_taxi_operator.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Address {

	// адрес регистрации пациента
	@Column(nullable = false)
	@Getter
	@Setter
	private String RegCountry; // страна

	@Column(nullable = false)
	@Getter
	@Setter
	private String RegRepublic; // республика

	@Column(nullable = false)
	@Getter
	@Setter
	private String RegArea; // область

	@Column(nullable = false)
	@Getter
	@Setter
	private String RegCity; // город
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String RegCommunity;// населенный пункт

	@Column(nullable = false)
	@Getter
	@Setter
	private String RegStreet; // улица
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String RegHouse; // дом
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String RegApartment; // квартира

	// адрес проживания пациента
	@Column(nullable = false)
	@Getter
	@Setter
	private String LivCountry; // страна

	@Column(nullable = false)
	@Getter
	@Setter
	private String LivRepublic; // республика

	@Column(nullable = false)
	@Getter
	@Setter
	private String LivArea; // область

	@Column(nullable = false)
	@Getter
	@Setter
	private String LivCity; // город
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String LivCommunity;// населенный пункт

	@Column(nullable = false)
	@Getter
	@Setter
	private String LivStreet; // улица
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String LivHouse; // дом
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String LivApartment; // квартира
	
	
	
	@Override
	public String toString(){
		return RegCountry+" "+RegRepublic+" "+RegArea+" "+RegCity+" "+RegCommunity+" "+RegStreet+" "+RegHouse+" "+RegApartment;
	}

}
