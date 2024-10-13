/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP 14 CM
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    public boolean existsByDocument(long document);
    public Person findByDocument(long document);
    
}
