package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor


public class ClinicalRecord {
	private Timestamp date;
    private String veterinarianDocument;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private String procedure;
    private String medication;
    private String medicationDose;
    private long orderId;
    private String vaccinationHistory;
    private String allergyMedications;
    private String procedureDetails;
    private boolean orderCancellation;
    
	public ClinicalRecord(Timestamp date, String veterinarianDocument, String consultationReason, String symptoms,
			String diagnosis, String procedure, String medication, String medicationDose, long orderId,
			String vaccinationHistory, String allergyMedications, String procedureDetails, boolean orderCancellation) {
		super();
		this.date = date;
		this.veterinarianDocument = veterinarianDocument;
		this.consultationReason = consultationReason;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.medication = medication;
		this.medicationDose = medicationDose;
		this.orderId = orderId;
		this.vaccinationHistory = vaccinationHistory;
		this.allergyMedications = allergyMedications;
		this.procedureDetails = procedureDetails;
		this.orderCancellation = orderCancellation;
	}
    
}
