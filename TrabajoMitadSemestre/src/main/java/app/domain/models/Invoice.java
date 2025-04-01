package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor


public class Invoice {
	private long invoiceId;
    private long petId;
    private long documentOwner;
    private long orderId;
    private String productName;
    private double value;
    private int amount;
    private Timestamp date;
	public Invoice(long invoiceId, long petId, long documentOwner, long orderId, String productName, double value,
			int amount, Timestamp date) {
		super();
		this.invoiceId = invoiceId;
		this.petId = petId;
		this.documentOwner = documentOwner;
		this.orderId = orderId;
		this.productName = productName;
		this.value = value;
		this.amount = amount;
		this.date = date;
	}
    
    

}
