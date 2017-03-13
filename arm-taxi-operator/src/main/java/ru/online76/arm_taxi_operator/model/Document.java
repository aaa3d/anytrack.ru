package ru.online76.arm_taxi_operator.model;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PersistenceContext;

import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Document {
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "number", length = 100, nullable = false)
	public String number="";
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String AmbCardNumber; // номер амбулаторной карты
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String MedicalArea; // врачебный участок
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String CodeOfPrivilege; // код категории льготы
	
	@Getter
	private Persona patient = new Persona();
	@Getter
	private PersonaDocument patient_document = new PersonaDocument();
	@Getter
	private Address address = new Address();
	@Getter
	private PatientPolice patient_police = new PatientPolice();
	
	
	
	@Override
	public String toString(){
		String result = number+" "+patient.toString()+" "+patient_police.toString()+" "+address.toString();
		if (result == null)
			result = "<null>";
		return result;
	}
	
	
	
	
}
