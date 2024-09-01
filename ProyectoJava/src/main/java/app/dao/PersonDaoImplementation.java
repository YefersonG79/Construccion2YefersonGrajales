package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dao.interfaces.PersonDao;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;

public class PersonDaoImplementation implements PersonDao {
    @Override
    public boolean existsByDocument(PersonDto personDto) throws Exception{
        String query = "SELECT FROM PERSON WHERE DOCUMENT = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, personDto.getDocument());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists = resultSet.next();
        resultSet.close();
        return exists;
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception{
        Person person = Helper.parse(personDto);
        String query = "INSERT INTO PERSON(NAME, DOCUMENT, CELLNUMBER) VALUES (?,?,?)";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, person.getName());
        preparedStatement.setLong(2, person.getDocument());
        preparedStatement.setLong(3, person.getPhoneNumber());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deletePerson(PersonDto personDto) throws Exception{
        Person person = Helper.parse(personDto);
        String query = "DELETE FROM PERSON WHERE DOCUMENT = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, person.getDocument());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public PersonDto findByDocument(PersonDto personDto) throws Exception{
        String query = "SELECT ID, NAME, DOCUMENT, CELLNUMBER FROM PERSON WHERE DOCUMENT = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, personDto.getDocument());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Person person = new Person();
            person.setId(resultSet.getLong("ID"));
            person.setName(resultSet.getString("NAME"));
            person.setDocument(resultSet.getLong("DOCUMENT"));
            person.setPhoneNumbre(resultSet.getLong("CELLNUMBER"));
            resultSet.close();
            preparedStatement.close();
            return Helper.parse(person);
        }

        resultSet.close();
        preparedStatement.close();
        return null;
    }
}