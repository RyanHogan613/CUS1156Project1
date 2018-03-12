import java.util.Scanner;

/**
 * Responsible for the UI of the restaurant interactions, displaying a
 * menu to the current restaurant that is signed into the system.
 */
public class RestaurantInterface {

    private RestaurantList restaurantList;
    private ReviewList reviewList;

    private String restID;

    public RestaurantInterface(ReservationSystem reservationSystem) {
        this.restaurantList = reservationSystem.getRestaurants();
        this.reviewList = reservationSystem.getReviews();
    }

    /**
     * Starts the interface by checking for the restaurant id,
     * then calling the menu if found
     */
    public void run() {

        Scanner in = new Scanner(System.in);

        while (!restaurantList.checkUser(restID)) {
            System.out.print("Enter your id: ");
            restID = in.next();

            if (restaurantList.checkUser(restID)) {
                menu();
            } else {
                System.out.println("Restaurant not found");
                System.out.println();
            }
        }

        in.close();
    }

    /**
     * Displays the UI menu to handle the users input and menu choices.
     * Will be called in the run method if a valid id is used
     */
    public void menu() {

        Scanner in = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("q")) {
            System.out.println();
            System.out.println("RESTAURANT INTERFACE");
            System.out.println();
            System.out.println("Please enter a command");
            System.out.println("SR: Show my Reviews");
            System.out.println("S: Show review statistics");
            System.out.println("Q: Quit");
            System.out.print("Enter: ");
            input = in.next();

            if (input.equalsIgnoreCase("SR")) {
                System.out.println();
                System.out.println("Reviews");
                System.out.println(reviewList.getReviewByRestID(restID));
            } else if (input.equalsIgnoreCase("S")) {
                System.out.println();
                System.out.println("Number of reviews: " + reviewList.getNumReviews(restID));
                System.out.println("Average score: " + reviewList.getReviewStats(restID));
            } else {
                System.out.println();
                System.out.println("Command not found");
            }
        }

        in.close();
        System.out.println();
        System.out.println("Bye!");
    }
}
