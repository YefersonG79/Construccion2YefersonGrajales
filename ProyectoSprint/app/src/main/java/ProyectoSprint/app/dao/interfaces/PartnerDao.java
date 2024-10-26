package ProyectoSprint.app.dao.interfaces;

import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.dto.UserDto;

public interface PartnerDao {
    public void createPartner(PartnerDto partnerDto) throws Exception;
    public PartnerDto findByUserId(UserDto userDto) throws Exception;
    public PartnerDto findById(PartnerDto PartnerDto) throws Exception;
    public boolean existsById(UserDto UserDto) throws Exception;
    public PartnerDto getMoneyByPartner(double getMoney) throws Exception;
    public void addfunds(PartnerDto partnerDto) throws Exception;
}
