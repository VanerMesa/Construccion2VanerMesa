package app.domain.models;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class OrderHeader {
	
	private long orderId;
	private Pet pet;
	private Person person;
	private Date dateCreated;
	private boolean status;
	
	
	public OrderHeader(long orderId, Pet pet, Person person, Date dateCreated,
			boolean status) {
		super();
		this.orderId = orderId;
		this.pet = pet;
		this.person = person;
		this.dateCreated = dateCreated;
		this.status = status;
	}
}
