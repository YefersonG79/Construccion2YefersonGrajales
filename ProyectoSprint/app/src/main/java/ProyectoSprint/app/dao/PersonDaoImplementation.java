package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.repositories.PersonRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ProyectoSprint.app.dao.interfaces.PersonDao;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.helpers.Helper;
import ProyectoSprint.app.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class PersonDaoImplementation implements PersonDao {
    
    @Autowired
    PersonRepository personRepository;
    @Override
    public boolean existsByDocument(PersonDto personDto) throws Exception{
        return personRepository.existsByDocument(Helper.parse(personDto).getDocument());
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception{
        Person person = Helper.parse(personDto);
        personRepository.save(person);
        personDto.setId(person.getId());
    }

    @Override
    public void deletePerson(PersonDto personDto) throws Exception{
        Person person = Helper.parse(personDto);
        personRepository.delete(person);
    }

    @Override
    public PersonDto findByDocument(PersonDto personDto) throws Exception{
        Person person = personRepository.findByDocument(personDto.getDocument());
        return Helper.parse(person);
    }
}