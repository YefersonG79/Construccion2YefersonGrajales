
package ProyectoSprint.app.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ProyectoSprint.app.model.Person;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository <Person,Long> {

    public boolean existsByCedula(Long cedula);
    public Person findByCedula(Long cedula);
    
}
