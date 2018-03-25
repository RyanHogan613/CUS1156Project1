import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RestaurantListTest {


    Restaurant restaurant;
    RestaurantList list = new RestaurantList();

    @Before
    public void setUp() throws Exception {
        list.add(restaurant = new Restaurant("12345", "Ryan's Pizza", "pizza",
                "8323 153th st", "Jamaica", "NY", "11432",
                true, 7));
    }


    @Test
    public void findRestaurantByName() throws Exception {
        List<Restaurant> compare = list.findRestaurantByName("Ryan's Pizza");
        assertEquals("Ryan's Pizza", compare.get(0).getName());
    }

    @Test
    public void findRestaurantByCuisine() throws Exception {
        List<Restaurant> compare = list.findRestaurantByCuisine("pizza");
        assertEquals("pizza", compare.get(0).getCuisine());
    }

    @Test
    public void findRestaurantByCity() throws Exception {
        List<Restaurant> compare = list.findRestaurantByCity("Jamaica");
        assertEquals("Jamaica", compare.get(0).getCity());
    }

    @Test
    public void findRestaurantByState() throws Exception {
        List<Restaurant> compare = list.findRestaurantByState("NY");
        assertEquals("NY", compare.get(0).getState());
    }

    @Test
    public void findRestaurantByID() throws Exception {
        List<Restaurant> compare = list.findRestaurantByID("12345");
        assertEquals("12345", compare.get(0).getId());
    }

    @Test
    public void findRestNameByID() throws Exception {
        List<Restaurant> compare = list.findRestaurantByName("Ryan's Pizza");
        assertEquals("Ryan's Pizza", compare.get(0).getName());
    }

    @Test
    public void checkUser() throws Exception {
        assertEquals(true, list.checkUser("12345"));
    }

}
