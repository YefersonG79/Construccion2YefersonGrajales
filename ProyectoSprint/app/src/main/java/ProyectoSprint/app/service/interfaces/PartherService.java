package ProyectoSprint.app.service.interfaces;

import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.dto.InvoiceDto;

public interface PartherService {
	public void createGuest(GuestDto guestDto) throws Exception;
	
	public void createInvoice(InvoiceDto invoiceDto) throws Exception;
	
	
}