package chapter5.spittr.data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String firstName;
    @NotNull
    @Size(min = 5, max = 16)
    private String lastName;
    @NotNull
    @Size(min = 2, max = 30)
    private String userName;
    @NotNull
    @Size(min = 2, max = 30)
    private String password;


    public Spitter(String firstName, String lastName, String userName, String password, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public Spitter(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public Spitter() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
