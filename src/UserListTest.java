import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserListTest {

    User user;
    UserList list = new UserList();

    @Before
    public void setUp() throws Exception {
        list.add(user = new User("jeff", "belge", "jbelge"));
    }

    @Test
    public void checkUser() throws Exception {
        assertEquals(true, list.checkUser("jbelge"));
    }

}
