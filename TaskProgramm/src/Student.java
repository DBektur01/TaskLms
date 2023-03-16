public class Student {
    private byte id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;

    public Student( String firstName, String lastName, String email, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    public  Student(){

    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return
                "\nid=          " + id +
                "\nfirstName=   " + firstName.toUpperCase() +
                "\nlastName=    " + lastName.toUpperCase() +
                "\nemail=       " + email +
                "\npassword=    " + password +
                "\ngender=      " + gender.toUpperCase() ;

    }
}
