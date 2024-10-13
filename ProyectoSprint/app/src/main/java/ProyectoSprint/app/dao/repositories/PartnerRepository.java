/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.Parther;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP 14 CM
 */
public interface PartnerRepository extends JpaRepository<Parther,Long>{

    public Parther findById(long id);
    
}
