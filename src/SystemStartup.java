import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * SystemStartup is responsible for loading all of the information from
 * the txt files into their respective classes. Also contains the main
 * method that sends the user to their respective interfaces
 */
public class SystemStartup {

    public static void main(String[] args) {
        UserInterface ui;
        RestaurantInterface ri;
        UserList users = loadUsers();
        RestaurantList restaurants = loadRestaurants();
        ReviewList reviews = loadReviews();
        ReservationList reservations = new ReservationList();

        ReservationSystem resSystem = new ReservationSystem(users, restaurants, reservations, reviews);
        System.out.println("What type of user are you? Type user or restaurant");
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        if (type.equals("user")){
            ui = new UserInterface(resSystem);
            ui.run();
        }
        else{
            ri = new RestaurantInterface(resSystem);
            ri.run();
        }

        in.close();
    }

    /**
     * Loads the list of restaurants from the rest.txt file into
     * the restaurant array list
     * @return the entire list of restaurants
     */
    private static RestaurantList loadRestaurants() {
        RestaurantList restList = new RestaurantList();
        Scanner fileIn;
        try {
            fileIn = new Scanner(new File("rest.txt"));


            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                Restaurant rest = processRestInputLine(line);
                restList.add(rest);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading restaurant file");
            e.printStackTrace();
        }
        return restList;
    }

    /**
     * Processes the list of restaurants in the txt file into a new restaurant object
     * @param line
     * @return the processed list of restaurants
     */
    private static Restaurant processRestInputLine(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        String id = lineScanner.next();
        String name = lineScanner.next();
        String cuisine = lineScanner.next();
        String addr1 = lineScanner.next();
        String city = lineScanner.next();
        String state = lineScanner.next();
        String zip = lineScanner.next();
        char liqFlag = lineScanner.next().charAt(0);
        Boolean hasLic;
        if (liqFlag == 'T')
            hasLic=true;
        else
            hasLic = false;
        int capacity = lineScanner.nextInt();

        Restaurant rest = new Restaurant(id, name, cuisine, addr1, city, state, zip, hasLic, capacity);

        lineScanner.close();
        return rest;
    }

    /**
     * Processes the list of users in the txt file into a new user object
     * @param line
     * @return the processed list of users
     */
    private static User processUserInputLine(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
        String id = lineScanner.next();
        String fname = lineScanner.next();
        String lname = lineScanner.next();

        User user = new User(fname,lname,id);

        lineScanner.close();
        return user;
    }

    /**
     * Processes the list of reviews in the txt file into a new review object
     * @param review_line
     * @return the processed list of reviews
     */
    private static Reviews processReviewInputLine(String review_line) {
        Scanner lineScanner = new Scanner(review_line);
        lineScanner.useDelimiter(",");

        String restName = lineScanner.next();
        String inspectionDate = lineScanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inspectionDate, formatter);
        String username = lineScanner.next();
        int numStars = Integer.parseInt(lineScanner.next());
        String reviewDescr = lineScanner.next();
        String restID = lineScanner.next();

        Reviews reviews = new Reviews(restName, date, username, numStars, reviewDescr, restID);

        lineScanner.close();

        return reviews;
    }

    /**
     * Loads the list of users from the users.txt file into
     * the user array list
     * @return the entire list of users
     */
    private static UserList loadUsers() {
        UserList userList = new UserList();
        Scanner fileIn;
        try {
            fileIn = new Scanner(new File("users.txt"));


            while (fileIn.hasNextLine()){
                String line = fileIn.nextLine();
                User user = processUserInputLine(line);

                userList.add(user);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.err.println("error reading user file");
            e.printStackTrace();
        }

        return userList;
    }

    /**
     * Loads the list of reviews from the reviews.txt file into
     * the reviews array list
     * @return the entire list of reviews
     */
    private static ReviewList loadReviews() {
        ReviewList reviewList = new ReviewList();
        Scanner fileIn;

        try {
            fileIn = new Scanner(new File("reviews.txt"));

            while(fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                Reviews reviews = processReviewInputLine(line);

                reviewList.add(reviews);
            }

            fileIn.close();
        } catch (FileNotFoundException e) {
            System.err.println("error reading restaurant file");
            e.printStackTrace();
        }

        return reviewList;
    }
}

