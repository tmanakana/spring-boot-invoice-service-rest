package co.za.digitalplatoon.invoiceservice.invoice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String client;
	private Long vatRate;
	private Date invoiceDate;
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<LineItem> lineItems;
	
	
	public Invoice() {
		super();
	}


	public Invoice(Long id, String client, Long vatRate, Date invoiceDate) {
		super();
		this.id = id;
		this.client = client;
		this.vatRate = vatRate;
		this.invoiceDate = invoiceDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public Long getVatRate() {
		return vatRate;
	}


	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}


	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public List<LineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public BigDecimal getSubtotal() {
		BigDecimal subtotal;
		subtotal = lineItems.stream().map(LineItem::getLineItemTotal).reduce((x,y) -> x.add(y)).get();
		subtotal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return subtotal;
	}
	
	public BigDecimal getVat() {
		double rate = vatRate / 100F;
		BigDecimal vat;
		vat = getSubtotal().multiply(BigDecimal.valueOf(rate));
		vat = vat.setScale(2, BigDecimal.ROUND_HALF_UP);
		return vat;
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = getSubtotal().add(getVat());
		total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
		return total;
	}
	
	
}
