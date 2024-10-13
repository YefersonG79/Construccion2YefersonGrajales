package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.repositories.PartnerRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ProyectoSprint.app.dao.interfaces.PartherDao;
import ProyectoSprint.app.dto.PartherDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.helpers.Helper;
import ProyectoSprint.app.model.Parther;
import ProyectoSprint.app.model.User;

public class PartherDaoImplementation implements PartherDao{
    
    PartnerRepository partnerRepository;
    @Override
    public void createrParther(PartherDto partherDto)throws Exception{
        Parther parther = Helper.parse(partherDto);
        partnerRepository.save(parther);
    }

    @Override
    public PartherDto findByPartherId (UserDto userDto) throws Exception{
        Parther parther = partnerRepository.findById(userDto.getId());
        return Helper.parse(parther);
    }

    @Override
    public void deleteParther (PartherDto partherDto) throws Exception{
        Parther parther = Helper.parse(partherDto);
        partnerRepository.delete(parther);
    }
}
