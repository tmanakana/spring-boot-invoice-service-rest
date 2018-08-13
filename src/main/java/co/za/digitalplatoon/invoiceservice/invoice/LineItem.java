package co.za.digitalplatoon.invoiceservice.invoice;


import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long quantity;
	private String description;
	private BigDecimal unitPrice;
	@Basic(optional = false)
	@NotNull
	@ManyToOne
    @JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	
	public LineItem() {
		super();
	}


	public LineItem(Long id, Long quantity, String description, BigDecimal unitPrice) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.description = description;
		this.unitPrice = unitPrice;
	}
	
	public LineItem(Long quantity, String description, BigDecimal unitPrice) {
		super();
		this.quantity = quantity;
		this.description = description;
		this.unitPrice = unitPrice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}


	@JsonIgnore
	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public BigDecimal getLineItemTotal() {
		BigDecimal bigDecimalQuantity = new BigDecimal(quantity);
		BigDecimal lineTotal;
		
		lineTotal = unitPrice.multiply(bigDecimalQuantity);
		lineTotal = lineTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return lineTotal;
	}
	
}
