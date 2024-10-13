package app.model;

public class User {
    private long id;
    private Person personId;
    private String name;
    private String password;
    private String role;

    public User(){
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Person getPersonid() {
		return personId;
	}

	public void setPersonid(Person personid) {
		this.personId = personid;
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

