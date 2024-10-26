
package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.interfaces.invoiceDetailDao;
import ProyectoSprint.app.dao.repositories.invoicedetailrepository;
import ProyectoSprint.app.model.InvoiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class invoicedetaildaoimplementation implements invoiceDetailDao{
     @Autowired
    invoicedetailrepository invoiceDetailRepository;
     
     @Override
    public void createInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
    }
}
