import java.util.ArrayList;

/**
 * RestaurantList controls the ArrayList of restaurants, allows the user
 * to access different searches and return methods of the list of restaurants
 */
public class RestaurantList {

    // Holds the list of restaurants
    private ArrayList<Restaurant> restList = new ArrayList<>();

    /**
     * Adds each restaurant into the array list
     * @param rest
     */
    public void add(Restaurant rest) {
        restList.add(rest);
    }

    /**
     * Searches for a restaurant by name
     * @param rest
     * @return the restaurant if found by name
     */
    public String findRestaurantByName(String rest) {

        ArrayList<String> temp = new ArrayList<>();

        for (Restaurant r : restList) {
            if (r.getName().equalsIgnoreCase(rest)) {
                temp.add(r.toString() + "\n");
            }
        }

        if (temp.isEmpty()) {
            return "No restaurant found";
        } else {
            return temp.toString();
        }
    }

    /**
     * Searches for a restaurant by cuisine
     * @param cuisine
     * @return the list restaurants if found by cuisine
     */
    public String findRestaurantByCuisine(String cuisine) {

        ArrayList<String> temp = new ArrayList<>();

        for (Restaurant r : restList) {
            if (r.getCuisine().equalsIgnoreCase(cuisine)) {
                temp.add(r.toString() + "\n");
            }
        }

        if (temp.isEmpty()) {
            return "No restaurant found";
        } else {
            return temp.toString();
        }
    }

    /**
     * Searches for a restaurant by city
     * @param city
     * @return the list restaurants if found by city
     */
    public String findRestaurantByCity(String city) {

        ArrayList<String> temp = new ArrayList<>();

        for (Restaurant r : restList) {
            if (r.getCity().equalsIgnoreCase(city)) {
                temp.add(r.toString() + "\n");
            }
        }

        if (temp.isEmpty()) {
            return "No restaurant found";
        } else {
            return temp.toString();
        }
    }


    /**
     * Searches for a restaurant by state
     * @param state
     * @return the list of restaurants found by state
     */
    public String findRestaurantByState(String state) {

        ArrayList<String> temp = new ArrayList<>();

        for (Restaurant r : restList) {
            if (r.getState().equalsIgnoreCase(state)) {
                temp.add(r.toString() + "\n");
            }
        }

        if (temp.isEmpty()) {
            return "No restaurant found";
        } else {
            return temp.toString();
        }
    }


    /**
     * Searches for a restaurant by id
     * @param id
     * @return the list of restaurants found by id
     */
    public String findRestaurantByID(String id) {

        ArrayList<String> temp = new ArrayList<>();

        for (Restaurant r : restList) {
            if (r.getId().equals(id)) {
                temp.add(r.toString() + "\n");
            }
        }

        if (temp.isEmpty()) {
            return "No restaurant found";
        } else {
            return temp.toString();
        }
    }

    /**
     * Searches for a restaurant by id and returns the restaurant name
     * @param id
     * @return name of restaurant
     */
    public String findRestNameByID(String id) {

        String rName = "";

        for (Restaurant r : restList) {
            if (r.getId().equals(id)) {
                rName = r.getName();
            }
        }

        return rName;
    }

    /**
     * Checks to see if the restaurant is in the system
     * @param rID
     * @return true if the restaurant is valid
     */
    public boolean checkUser(String rID) {

        for (Restaurant r : restList) {
            if (r.getId().equals(rID)) {
                return true;
            }
        }

        return false;
    }

}