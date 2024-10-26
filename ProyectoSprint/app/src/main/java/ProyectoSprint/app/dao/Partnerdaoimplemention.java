
package ProyectoSprint.app.dao;

import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.dao.interfaces.PartnerDao;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.dao.repositories.PartnerRepository;
import ProyectoSprint.app.helpers.Helpers;
import ProyectoSprint.app.model.Partner;
import ProyectoSprint.app.model.User;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class Partnerdaoimplemention implements PartnerDao {

    @Autowired
    PartnerRepository PartnerRepository;

    public PartnerDto findById(PartnerDto PartnerDto) throws Exception {
        Partner partner = PartnerRepository.findByid(PartnerDto.getId());
        return Helpers.parse(partner);
    }

    public boolean existsById(UserDto UserDto) throws Exception {
        return PartnerRepository.existsById(UserDto.getId());
    }

    public void createPartner(PartnerDto PartnerDto) throws Exception {
        Partner partner = Helpers.parse(PartnerDto);
        PartnerRepository.save(partner);
        PartnerDto.setId(partner.getId());

    }

    @Override
    public PartnerDto findByUserId(UserDto userDto) throws Exception {
        User user = Helpers.parse(userDto);
        Partner partner = PartnerRepository.findByUserId(user);
        if (partner == null) {
            return null;
        }
        return Helpers.parse(partner);
    }
    public PartnerDto getMoneyByPartner(double monto) throws Exception {
        Partner partner = PartnerRepository.findByMoney(monto);
        return Helpers.parse(partner);
    }
    @Override
    @Transactional
    
    public void addfunds(PartnerDto partnerDto) throws Exception{
        PartnerRepository.updateMoneyByUserId(partnerDto.getMoney(),partnerDto.getUserId().getId());
    }

}
