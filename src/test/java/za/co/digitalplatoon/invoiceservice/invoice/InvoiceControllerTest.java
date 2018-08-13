package za.co.digitalplatoon.invoiceservice.invoice;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.za.digitalplatoon.invoiceservice.invoice.Invoice;
import co.za.digitalplatoon.invoiceservice.invoice.InvoiceController;
import co.za.digitalplatoon.invoiceservice.invoice.InvoiceService;
import co.za.digitalplatoon.invoiceservice.invoice.InvoiceServiceRestApplication;
import co.za.digitalplatoon.invoiceservice.invoice.LineItem;

@RunWith(SpringRunner.class)
@WebMvcTest(value = InvoiceController.class, secure = false)
@ContextConfiguration(classes={InvoiceServiceRestApplication.class})
public class InvoiceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InvoiceService invoiceService;
	
	@Test
	public void createInvoice() throws Exception{
		Invoice mockInvoice = new Invoice();
		mockInvoice.setClient("FNB Contact Center");
		mockInvoice.setInvoiceDate(new Date());
		mockInvoice.setVatRate(15L);
		
		String jsonInvoiceExample = "{\n" + 
				"	\"client\":\"MUTUAL INSURANCE PTY LTD\",\n" + 
				"	\"vatRate\":\"14\",\n" + 
				"	\"invoiceDate\":\"2018-08-10T20:36:28.078+0000\",\n" + 
				"	\"lineItems\": [\n" + 
				"		{\n" + 
				"        \"quantity\": 2,\n" + 
				"        \"description\": \"KEY BOARD\",\n" + 
				"        \"unitPrice\": 300\n" + 
				"		},\n" + 
				"		{\n" + 
				"        \"quantity\": 2,\n" + 
				"        \"description\": \"MOUSE\",\n" + 
				"        \"unitPrice\": 350.90\n" + 
				"		}\n" + 
				"	 ]\n" + 
				"}";
		
		List<LineItem> lineItems = new ArrayList<>();
		lineItems.add(new LineItem(10L,"Developer billable hours",new BigDecimal("1200")));
		lineItems.add(new LineItem(10L,"Business Analyst billable hours",new BigDecimal("1300")));
		lineItems.add(new LineItem(10L,"Code Monkey billable hours",new BigDecimal("900")));
		lineItems.add(new LineItem(10L,"Thee consultant billable hours ijoh!",new BigDecimal("1900")));
		
		mockInvoice.setLineItems(lineItems);
		
		
		Mockito.when(
				invoiceService.addInvoice(Mockito.any(Invoice.class))).thenReturn(mockInvoice);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/invoices")
				.accept(MediaType.APPLICATION_JSON).content(jsonInvoiceExample)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}

}
