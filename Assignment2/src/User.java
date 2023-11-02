public class User {
    private String name;
    private String email;
    private String ID;
    private String password;

    User(){

    }
    User(String name , String email,String ID, String password){
        this.name = name;
        this.ID = ID;
        this.password= password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}
