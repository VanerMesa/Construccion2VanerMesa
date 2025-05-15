package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class InvoiceDetail {
	
	private long invoiceDetailId;
	private InvoiceHeader invoiceHeader;
	private OrderHeader orderHeader;
	private String nameProduct;
	private double amount;
	private int quantity;
	
	
	public InvoiceDetail(long invoiceDetailId, InvoiceHeader invoiceHeader, OrderHeader orderHeader, String nameProduct,
			double amount, int quantity) {
		super();
		this.invoiceDetailId = invoiceDetailId;
		this.invoiceHeader = invoiceHeader;
		this.orderHeader = orderHeader;
		this.nameProduct = nameProduct;
		this.amount = amount;
		this.quantity = quantity;
	}

}