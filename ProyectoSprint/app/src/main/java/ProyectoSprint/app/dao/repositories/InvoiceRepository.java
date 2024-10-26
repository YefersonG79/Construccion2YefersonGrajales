
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository <invoice,Long>{
    
}
