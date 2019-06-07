package ch.rohner.asusLed.daos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USERS")
public class User {

    @Id
    private String userid;
    private String firstName;
    private String lastName;
    private String password;

    public User() {
    }

    public User(String userid, String firstName, String lastName, String password) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
