/**
 * Restaurant is the wrapper class that handles the attributes for the restaurants
 * in the list of restaurants.
 */
public class Restaurant {

    private String  id;
    private String name;
    private String cuisine;
    private String addr1;
    private String city;
    private String state;
    private String zip;
    private boolean hasLic;
    private int capacity;

    public Restaurant(String ID, String r_name, String r_cuisine, String r_addr, String r_city,
                      String r_state, String r_zip, boolean r_hasLic, int r_capacity) {
        this.id = ID;
        this.name = r_name;
        this.addr1 = r_addr;
        this.city = r_city;
        this.cuisine = r_cuisine;
        this.state = r_state;
        this.zip = r_zip;
        this.hasLic = r_hasLic;
        this.capacity = r_capacity;
    }


    public void setId(String ID) {
        this.id = ID;
    }

    public String getId() {
        return id;
    }

    public void setName(String r_name) {
        this.name = r_name;
    }

    public String getName() {
        return  name;
    }

    public void setCuisine(String r_cuisine) {
        this.cuisine = r_cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setAddr1(String r_addr) {
        this.addr1 = r_addr;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setHasLic(boolean hasLic) {
        this.hasLic = hasLic;
    }

    public boolean isHasLic() {
        return hasLic;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


    @Override
    public String toString() {
        return  "  ID: " + id +
                "  Name: " + name +
                "  Cuisine: " + cuisine +
                "  Address: " + addr1 +
                "  City: " + city +
                "  State: " + state +
                "  Zip: " + zip +
                "  Has Lic: " + hasLic +
                "  Capacity: " + capacity;
    }

}
