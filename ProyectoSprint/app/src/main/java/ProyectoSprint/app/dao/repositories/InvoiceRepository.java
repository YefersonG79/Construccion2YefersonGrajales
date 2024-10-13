/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP 14 CM
 */
public interface InvoiceRepository extends JpaRepository<Invoice,Long>{
    
}
