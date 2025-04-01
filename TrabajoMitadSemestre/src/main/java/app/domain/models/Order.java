package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Order {
    private long orderId;
    private long petId;
    private long documentOwner;
    private long veterinarianId;
    private String medicationName;
    private String dose;
    private Timestamp generationDate;
	public Order(long orderId, long petId, long ownerId, long veterinarianId, String medicationName, String dose,
			Timestamp generationDate) {
		super();
		this.orderId = orderId;
		this.petId = petId;
		this.documentOwner = ownerId;
		this.veterinarianId = veterinarianId;
		this.medicationName = medicationName;
		this.dose = dose;
		this.generationDate = generationDate;
	}  
    
}
