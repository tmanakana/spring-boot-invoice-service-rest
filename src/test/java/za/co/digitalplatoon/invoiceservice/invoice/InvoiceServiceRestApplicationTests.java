package za.co.digitalplatoon.invoiceservice.invoice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ContextConfiguration;
import co.za.digitalplatoon.invoiceservice.invoice.InvoiceServiceRestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={InvoiceServiceRestApplication.class})
public class InvoiceServiceRestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
