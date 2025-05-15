package app.domain.models;

import java.sql.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class InvoiceHeader {
	
	private long invoiceHeaderId;
	private Pet pet;
	private Person person;	
	private Date dateCreated; 
	private double amount;
	private boolean status;
	
	public InvoiceHeader(long invoiceHeaderId, Pet pet, Person person, Date dateCreated, double amount, boolean status) {
		super();
		this.invoiceHeaderId = invoiceHeaderId;
		this.pet = pet;
		this.person = person;
		this.dateCreated = dateCreated;
		this.amount = amount;
		this.status = status;
	}	

}