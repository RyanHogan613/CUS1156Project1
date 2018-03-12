import java.time.LocalDate;
import java.util.Scanner;

/**
 * Responsible for the UI of the user interactions, displaying a
 * menu to the current user that is signed into the system.
 */
public class UserInterface {

    private UserList userList;
    private RestaurantList restaurantList;
    private ReviewList reviewList;

    private String userID;

    public UserInterface(ReservationSystem reservationSystem) {
        userList = reservationSystem.getUsers();
        restaurantList = reservationSystem.getRestaurants();
        reviewList = reservationSystem.getReviews();
    }


    /**
     * Starts the user interface class and is called
     * in SystemStartup to run the UI
     */
    public void run() {
        Scanner in = new Scanner(System.in);

        while (!userList.checkUser(userID)) {

            System.out.print("Enter your id: ");
            userID = in.nextLine();

            if (userList.checkUser(userID)) {
                menu();
            } else {
                System.out.println();
                System.out.println("User not found");
                System.out.println();
            }
        }

        in.close();
    }

    /**
     * Provides the UI for the user interface class, displays a menu
     * prompting the user to enter a command.
     */
    public void menu() {

        Scanner in = new Scanner(System.in);
        String userInput = "";                       // Holds users menu choice
        String searchChoice;                         // Holds users restaurant search option

        while (!userInput.equalsIgnoreCase("q")) {
            System.out.println();
            System.out.println("USER INTERFACE");
            System.out.println();
            System.out.println("Please enter a command");
            System.out.println("S: Search for Restaurants");
            System.out.println("D: Display Restaurants");
            System.out.println("C: Add a Review");
            System.out.println("SR: Show my Reviews");
            System.out.println("Q: Quit");
            System.out.print("Enter: ");
            userInput = in.next();
            System.out.println();

            if (userInput.equalsIgnoreCase("S")) {
                System.out.println("What would you like to search on? Choose one");
                System.out.println("cuisine, city, state, name?");
                System.out.print("Enter: ");
                searchChoice = in.next();

                if (searchChoice.equalsIgnoreCase("cuisine")) {
                    System.out.print("Enter the cuisine: ");
                    String cuisine = in.next();
                    System.out.println(restaurantList.findRestaurantByCuisine(cuisine));

                } else if (searchChoice.equalsIgnoreCase("name")) {
                    in.nextLine();
                    System.out.print("Enter the name: ");
                    String name = in.nextLine();
                    System.out.println();
                    System.out.println(restaurantList.findRestaurantByName(name));
                    System.out.println();
                    System.out.println("Reviews");
                    System.out.println();
                    System.out.println(reviewList.getReviewByUname(name));

                } else if (searchChoice.equalsIgnoreCase("city")) {
                    in.nextLine();
                    System.out.print("Enter the city: ");
                    String city = in.nextLine();
                    System.out.println();
                    System.out.println(restaurantList.findRestaurantByCity(city));
                    System.out.println();

                } else if (searchChoice.equalsIgnoreCase("state")) {
                    System.out.print("Enter the state: ");
                    String state = in.next();
                    System.out.println(restaurantList.findRestaurantByState(state));

                } else {
                    System.out.println();
                    System.out.println("Try again");
                }

            } else if (userInput.equalsIgnoreCase("D")) {

                System.out.print("Enter the restaurant id: ");
                String restID = in.next();

                if (!restaurantList.checkUser(restID)) {
                    System.out.println("Restaurant not found, try again");
                } else {
                    System.out.print(restaurantList.findRestaurantByID(restID));
                    System.out.println();
                    System.out.println("Reviews");
                    System.out.println(reviewList.getReviewByRestID(restID));
                    System.out.println();
                }

            } else if (userInput.equalsIgnoreCase("C")) {

                LocalDate date = LocalDate.now();
                System.out.print("Enter the restaurant id: ");
                String restID = in.next();

                if (!restaurantList.checkUser(restID)) {
                    System.out.println("ID not found, try again");
                } else {
                    in.nextLine();
                    System.out.print("Enter your review: ");
                    String review = in.nextLine();
                    System.out.print("Enter the number of stars: ");
                    int numStars = Integer.parseInt(in.next());

                    String rName = restaurantList.findRestNameByID(restID);

                    reviewList.add(new Reviews(rName, date, userID, numStars, review, restID));

                    reviewList.writeReviewToFile(new Reviews(rName, date, userID, numStars, review, restID));
                }

            } else if (userInput.equalsIgnoreCase("SR")) {
                System.out.println("Your Reviews: ");
                System.out.println(reviewList.getReviewByUname(userID));
            } else {
                System.out.println("Command not found");
            }
        }

        in.close();
        System.out.println("");
        System.out.println("Bye!");
    }

}

