package co.za.digitalplatoon.invoiceservice.invoice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	public Invoice addInvoice(Invoice invoice) {
		for  (LineItem lineItem : invoice.getLineItems()) {
			lineItem.setInvoice(invoice);
		}
		invoiceRepository.save(invoice);
		return invoice;
	}
	
	public Invoice viewInvoice(Long id) {
		return invoiceRepository.findById(id).get();
	}

	public List<Invoice> viewAllInvoices() {
		
		List<Invoice> invoiceList = new ArrayList<>();
		invoiceRepository.findAll()
		.forEach(invoiceList::add);
		return invoiceList;
	}

}
