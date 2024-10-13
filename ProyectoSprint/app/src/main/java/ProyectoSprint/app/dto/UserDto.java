package app.dto;

public class UserDto {
    private long id;
    private PersonDto personId;
    private String name;
    private String password;
    private String role;

    public UserDto(){
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public PersonDto getPersonId() {
        return personId;
    }

    public void setPersonid(PersonDto personId){
        this.personId = personId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}