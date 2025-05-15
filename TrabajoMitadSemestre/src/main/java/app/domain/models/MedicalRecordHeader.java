package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class MedicalRecordHeader {
	
	private long medicalRecordHeaderId;
	private Pet pet;
	private Person person;
	
	
	public MedicalRecordHeader(long medicalRecordHeaderId, Pet pet, Person person) {
		super();
		this.medicalRecordHeaderId = medicalRecordHeaderId;
		this.pet = pet;
		this.person = person;
	}
}
