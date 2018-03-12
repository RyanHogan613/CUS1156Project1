/**
 * Reservation system is responsible for loading the users, restaurants,
 * reservations, and reviews into the interface classes in order to access
 * the information in each class.
 *
 * The ReservationSystem constructor gets invoked when a valid user/restaurant is
 * entered in the interfaces, respectively.
 */
public class ReservationSystem {

    private UserList users;
    private RestaurantList restaurants;
    private ReservationList reservations;
    private ReviewList reviews;

    public ReservationSystem(UserList userList, RestaurantList restaurantList, ReservationList reservationList,
                             ReviewList reviewList) {
        this.users = userList;
        this.restaurants = restaurantList;
        this.reservations = reservationList;
        this.reviews = reviewList;
    }

    public void setUsers(UserList users) {
        this.users = users;
    }

    public UserList getUsers() {
        return users;
    }

    public void setRestaurants(RestaurantList restaurants) {
        this.restaurants = restaurants;
    }

    public RestaurantList getRestaurants() {
        return restaurants;
    }

    public void setReservations(ReservationList reservations) {
        this.reservations = reservations;
    }

    public ReservationList getReservations() {
        return reservations;
    }

    public void setReviews(ReviewList reviews) {
        this.reviews = reviews;
    }

    public ReviewList getReviews() {
        return reviews;
    }
}

