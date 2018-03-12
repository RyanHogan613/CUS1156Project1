import java.util.ArrayList;

/**
 * UserList controls the ArrayList of users
 */
public class UserList {

    // Holds the list of users
    private ArrayList<User> userList = new ArrayList<>();

    /**
     * Adds a new user to the list
      * @param user
     */
    public void add(User user) {
        userList.add(user);
    }

    /**
     * Checks to see if the user is in the system
     * @param id
     * @return true if the user is valid
     */
    public boolean checkUser(String id) {
        for (User u : userList) {
            if (u.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

}
