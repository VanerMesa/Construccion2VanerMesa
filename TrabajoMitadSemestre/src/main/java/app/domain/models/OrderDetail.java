package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	
@Getter 
@NoArgsConstructor

public class OrderDetail {
	
	private long orderDetailId;
	private OrderHeader orderHeader;
	private String medicineName;
	private String dosage;
	
	
	public OrderDetail(long orderDetailId, OrderHeader orderHeader, String medicineName, String dosage) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderHeader = orderHeader;
		this.medicineName = medicineName;
		this.dosage = dosage;
	}
}