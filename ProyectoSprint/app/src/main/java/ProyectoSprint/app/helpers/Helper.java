package ProyectoSprint.app.helpers;

import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.dto.PartherDto;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.model.Guest;
import ProyectoSprint.app.model.Parther;
import ProyectoSprint.app.model.Person;
import ProyectoSprint.app.model.User;

public abstract class Helper {

    public static PersonDto parse(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setDocument(person.getDocument());
        personDto.setName(person.getName());
        personDto.setPhoneNumber(person.getPhoneNumber());
        return personDto;
    }

    public static Person parse(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getDocument());
        person.setDocument(personDto.getDocument());
        person.setName(personDto.getName());
        person.setPhoneNumber(personDto.getPhoneNumber());
        return person;
    }

    public static UserDto parse(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setRole(user.getRole());
        userDto.setName(user.getUsername());
        return userDto;
        }

    public static User parse(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setPersonId(parse(userDto.getPersonId()));
        user.setRole(userDto.getRole());
        user.setUsername(userDto.getName());
        return user;
    }

    public static PartherDto parse(Parther parther){
        PartherDto partherDto = new PartherDto();
        partherDto.setId(parther.getId());
        partherDto.setUserId(parse(parther.getUserId()));
        partherDto.setAvailableFunds(parther.getAvailableFunds());
        partherDto.setSubscriptionType(parther.getSubscriptionType());
        partherDto.setMembersphipDate(parther.getMembersphipDate());
        return partherDto;
    }

    public static Parther parse(PartherDto partherDto){
        Parther parther = new Parther();
        parther.setId(partherDto.getId());
        parther.setUserId(parse(partherDto.getUserId()));
        parther.setAvailableFunds(partherDto.getAvailableFunds());
        parther.setSubscriptionType(partherDto.getSubscriptionType());
        parther.setMembersphipDate(partherDto.getMembersphipDate());
        return parther;
    }
    

    public static GuestDto parse(Guest guest){
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setUserId(parse(guest.getUserId()));
        guestDto.setPartherId(parse(guest.getPartherId()));
        guestDto.setGuestStatus(guest.getGuestStatus());
        return guestDto;
    }

    public static Guest parse(GuestDto guestDto){
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setUserId(parse(guestDto.getUserId()));
        guest.setPartherId(parse(guestDto.getPartherId()));
        guest.setGuestStatus(guest.getGuestStatus());
        return guest;
    }
}