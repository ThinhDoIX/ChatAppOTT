package appchat.kuroneko.appchatott;

public class User {

    public String name, email, phone;
    // not store passwords

    public User () {

    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
