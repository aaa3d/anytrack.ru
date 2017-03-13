package ru.online76.arm_taxi_operator.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Embeddable
public class Persona{
	@Column(nullable = false)
	@Getter
	@Setter
	private String Name;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String Surname;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String SecondName;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String Phone;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String Sex;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String birthDate;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String Snils;
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		return SecondName+" "+Name+" "+Surname;
	}
	
	
	
	
	
}
