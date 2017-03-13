package ru.online76.arm_taxi_operator.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class PatientPolice {
	// страховой мед полис
	@Column(nullable = false)	
	@Getter
	@Setter
	private String SRegion; // регион страхования
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String SMO; // страховая компания
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String SMOSeries; // серия полиса
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String SMONumber; // номер полиса
	
	
	@Override
	public String toString(){
		return SMO+" "+SMOSeries+" "+SMONumber;
	}
}
