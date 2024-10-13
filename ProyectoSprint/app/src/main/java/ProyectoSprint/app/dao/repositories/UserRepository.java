/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoSprint.app.dao.repositories;

import ProyectoSprint.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP 14 CM
 */
@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    public User findByUsername(String name);

    public boolean existsByUsername(String name);
    
}
