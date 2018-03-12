/**
 * User is the wrapper class that handles the attributes for the users
 * in the list of users.
 */
public class User {

    private String fName;
    private String lName;
    private String id;

    public User(String first, String last, String ID) {
        this.fName = first;
        this.lName = last;
        this.id = ID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    public void setlNmae(String lName) {
        this.lName = lName;
    }

    public String getlName() {
        return lName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
