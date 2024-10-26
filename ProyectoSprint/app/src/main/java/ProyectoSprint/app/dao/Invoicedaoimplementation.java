
package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.interfaces.invoiceDao;
import ProyectoSprint.app.dao.repositories.InvoiceRepository;
import ProyectoSprint.app.model.invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class Invoicedaoimplementation implements invoiceDao{
     @Autowired
    InvoiceRepository invoiceRepository;
    public void createInvoice(invoice invoice) throws Exception{
        invoiceRepository.save(invoice);
    }
}
