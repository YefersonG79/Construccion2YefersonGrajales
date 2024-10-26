
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface invoicedetailrepository extends JpaRepository <InvoiceDetail,Long> {
    
}
