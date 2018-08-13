package co.za.digitalplatoon.invoiceservice.invoice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(method=RequestMethod.POST, value="/invoices")
	public Invoice addInvoice(@RequestBody Invoice invoice) {
		return invoiceService.addInvoice(invoice);
	}
	
	@RequestMapping("/invoices")
	public List<Invoice> viewAllInvoices() {
		return invoiceService.viewAllInvoices();
	}
	
	@RequestMapping("/invoices/{id}")
	public Invoice viewInvoice(@PathVariable Long id) {
		return invoiceService.viewInvoice(id);
	}
}
