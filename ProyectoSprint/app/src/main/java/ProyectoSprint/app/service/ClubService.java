package ProyectoSprint.app.service;

import java.sql.SQLException;


import ProyectoSprint.app.dao.interfaces.UserDao;
import ProyectoSprint.app.dao.interfaces.GuestDao;
import ProyectoSprint.app.dao.interfaces.PartnerDao;
import ProyectoSprint.app.dao.interfaces.PersonDao;
import ProyectoSprint.app.dao.interfaces.invoiceDao;
import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.dto.invoiceDetailDto;
import ProyectoSprint.app.dto.invoiceDto;
import ProyectoSprint.app.controller.utils;
import ProyectoSprint.app.dao.interfaces.invoiceDetailDao;
import ProyectoSprint.app.helpers.Helpers;
import ProyectoSprint.app.model.InvoiceDetail;
import ProyectoSprint.app.model.invoice;
import ProyectoSprint.app.service.interfaces.AdminService;
import ProyectoSprint.app.service.interfaces.LoginService;
import ProyectoSprint.app.service.interfaces.PartnerService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class ClubService implements LoginService, AdminService, PartnerService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GuestDao guestdao;
    @Autowired
    private PartnerDao partnerdao;
    @Autowired
    private PersonDao persondao;
    @Autowired
    private invoiceDao invoicedao;
    @Autowired
    private invoiceDetailDao invoicedetaildao;
    
    public static UserDto user;
    
    public static double addfunds;

    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUsername(userDto);
        if (validateDto == null) {
            throw new Exception("no existe usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            System.out.println(validateDto.getPassword());
            System.out.println(userDto.getPassword());
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRol(validateDto.getRol());
        user = validateDto;

    }

    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createPerson(PersonDto personDto) throws Exception {
        if (this.persondao.existsByCedula(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
        }
        this.persondao.createPerson(personDto);
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        if (this.userDao.existsByUsername(userDto)) {
            this.persondao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userDao.createUser(userDto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.persondao.deletePerson(userDto.getPersonId());
        }
    }

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userDao.findByUsername(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        this.partnerdao.createPartner(partnerDto);

    }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception {
        this.createUser(GuestDto.getUser());
        PartnerDto partnerDto = partnerdao.findByUserId(user);
        
        GuestDto.setPartner(partnerDto);
        
        GuestDto.setStatus("Inactivo");
        guestdao.createGuest(GuestDto);

    }
    public GuestDto getGuestById(long guestId) throws Exception {
        return guestdao.getGuestById(guestId);
    }
     public void updateGuestStatus(GuestDto guestDto) throws Exception{
         guestdao.ActivateStatus(guestDto);
     }
     public void addfunds () throws Exception{
       UserDto user = ClubService.user;
       PartnerDto partner = partnerdao.findByUserId(user);
       System.out.println("Bienvenido su monto actual es: "+partner.getMoney()+" y su tipo de socio es: "+partner.getType());
       System.out.println("Ingresa el monto que desea agregar");
       double monto =Double.parseDouble(utils.getReader().nextLine());
       monto= partner.getMoney()+monto;
       addfunds=monto;
       if(partner.getType().equals("regular") && addfunds>=1000000){
           System.out.println("No puedes tener mas de 1000000");
           addfunds=addfunds - monto;
       }
       
       else if (partner.getType().equals("vip") && addfunds>=5000000){
           System.out.println("No puedes tener mas de 5000000");
       }
       partner.setMoney(addfunds);
       this.partnerdao.getMoneyByPartner(addfunds);
       this.partnerdao.addfunds(partner);
            
 
       
     
}
      public void createinvoice() throws Exception {
       double monto=0;
       String descripcion;
       UserDto userDto = ClubService.user;
       PartnerDto partner = partnerdao.findByUserId(userDto);
       PersonDto person = persondao.findByCedula(userDto.getPersonId());
       System.out.println("Bienvenido "+partner.getUserId().getUsername()+" ingresa la cantidad de items a consumir");
       int items = utils.getReader().nextInt();
       List <invoiceDetailDto> invoices = new ArrayList<invoiceDetailDto>();
       invoiceDto invoiceDto = new invoiceDto();
       invoiceDto.setPartner(partner);
       invoiceDto.setPerson(person);
       invoiceDto.setStatus("Pago pendiente");
       invoiceDto.setDateCreate(new Timestamp(System.currentTimeMillis()));
          for (int i = 0; i < items; i++) {
              invoiceDetailDto invoicedetail = new invoiceDetailDto();
              invoicedetail.setInvoice(invoiceDto);
              invoicedetail.setItem(i+1);
              System.out.println("Ingrese el monto del item "+invoicedetail.getItem());
              invoicedetail.setAmount(utils.getReader().nextDouble());
              System.out.println("Ingrese la descripcion del item "+invoicedetail.getItem());
              invoicedetail.setDescription("item: "+(i+1)+" "+utils.getReader().next());
              monto=monto+invoicedetail.getAmount();
              invoices.add(invoicedetail);
          }
          invoiceDto.setAmount(monto);
       invoice invoice=Helpers.Parse(invoiceDto);
       invoicedao.createInvoice(invoice);
       
       for(invoiceDetailDto detail:invoices){
           detail.setInvoice(invoiceDto);
          InvoiceDetail invoiceDetail = Helpers.parse(detail);
          invoiceDetail.setInvoiceid(invoice);
          invoicedetaildao.createInvoiceDetail(invoiceDetail);
       }
        System.out.println("Factura creada");
        
       
   }

}