package app.domain.models;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class MedicalRecordDetail {
	
	private long medicalRecordDetailId;
	private Date dateCreated; 
	private MedicalRecordHeader medicalRecordHeader;
	private Person person;
	private String reasonForConsultation;
	private String symptoms;
	private String diagnosis;
    private String procedure;
    private OrderHeader orderHeader;
    private String allergies;
    private String procedureDetails;
    private String vaccineName; 
    private boolean orderCancelled;
    
    
	public MedicalRecordDetail(long medicalRecordDetailId, Date dateCreated, MedicalRecordHeader medicalRecordHeader,
			Person person, String reasonForConsultation, String symptoms, String diagnosis,
			String procedure, OrderHeader orderHeader, String allergies, String procedureDetails, String vaccineName,
			boolean orderCancelled) {
		super();
		this.medicalRecordDetailId = medicalRecordDetailId;
		this.dateCreated = dateCreated;
		this.medicalRecordHeader = medicalRecordHeader;
		this.person = person;
		this.reasonForConsultation = reasonForConsultation;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.orderHeader = orderHeader;
		this.allergies = allergies;
		this.procedureDetails = procedureDetails;
		this.vaccineName = vaccineName;
		this.orderCancelled = orderCancelled;
	}	 
    
}
