package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dao.interfaces.PartherDao;
import app.dto.PartherDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Parther;
import app.model.User;

public class PartherDaoImplementation implements PartherDao{
    @Override
    public void createrParther(PartherDto partherDto)throws Exception{
        Parther parther = Helper.parse(partherDto);
        String query = "INSERT INTO PARTHER(USERID, AMOUNT, TYPE, CREATIONDATE) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, parther.getUserId().getId());
        preparedStatement.setLong(2, parther.getAvailableFunds());
        preparedStatement.setString(3, parther.getSubscriptionType());
        preparedStatement.setDate(4, parther.getMembersphipDate());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public PartherDto existById(UserDto userDto) throws Exception{
        String query = "SELECT ID, USERID, AMOUNT, TYPE, CREATIONDATE FROM PARTHER WHERE USERID = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, userDto.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Parther parther = new Parther();
            parther.setId(resultSet.getLong("ID"));
            parther.setAvailableFunds(resultSet.getLong("AMOUNT"));
            parther.setSubscriptionType(resultSet.getString("TYPE"));
            parther.setMembersphipDate(resultSet.getDate("CREATIONDATE"));
            User user = new User();
            user.setId(resultSet.getLong("USERID"));
            parther.setUserId(user);
            resultSet.close();
            preparedStatement.close();
            return Helper.parse(parther);
        }
        resultSet.close();
        preparedStatement.close();
        return null;

    }

    @Override
    public void deleteParther (PartherDto partherDto) throws Exception{
        Parther parther = Helper.parse(partherDto);
        String query = "DELETE FROM PARTHER WHERE USERID = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, parther.getUserId().getId());
        preparedStatement.execute();
        preparedStatement.close();
    }
}
