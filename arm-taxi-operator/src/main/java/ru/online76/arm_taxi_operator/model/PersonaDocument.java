package ru.online76.arm_taxi_operator.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class PersonaDocument {

	// документ удостоверяющий личность
	@Getter
	@Setter
	private String DocumentType; // тип документа

	@Getter
	@Setter
	private String DocumentSeries; // серия

	@Getter
	@Setter
	private String DocumentNumber; // номер
	
	
	@Override
	public String toString(){
		return DocumentType+" "+DocumentSeries+" "+DocumentNumber;
	}

}
