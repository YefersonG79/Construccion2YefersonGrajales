
package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.interfaces.PersonDao;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.helpers.Helpers;
import ProyectoSprint.app.model.Person;
import ProyectoSprint.app.dao.repositories.PersonRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter
@NoArgsConstructor
public  class Persondaoimplementation implements PersonDao{
    
    @Autowired
    PersonRepository personrepository ;
    public boolean existsByCedula(PersonDto personDto) throws Exception {
        
        return personrepository.existsByCedula(Helpers.parse(personDto).getCedula());
        
	}
    public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		personrepository.save(person);
                personDto.setId(person.getId());
                
	}
    public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		personrepository.delete(person);
    }
    public PersonDto findByCedula(PersonDto personDto) throws Exception {
         Person person = personrepository.findByCedula(personDto.getCedula());
         return Helpers.parse(person);
	}	
	
}