import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReviewList controls the ArrayList of reviews, allows the access of
 * different searches and return methods of the list of reviews
 */
public class ReviewList {

    // Holds the list of reviews
    private ArrayList<Reviews> reviewList = new ArrayList<>();

    /**
     * Adds a new review to the review array list
     * @param rest
     */
    public void add(Reviews rest) {
        reviewList.add(rest);
    }

    /**
     * Returns a review based off it's restaurant id
     * @param rID
     * @return the Review with the corresponding restaurant id
     */
    public List<Reviews> getReviewByRestID(String rID) {

        List<Reviews> temp = new ArrayList<>();

        for (Reviews r : reviewList) {
            if (r.getID().equals(rID)) {
                temp.add(r);
            }
        }

        return temp;
    }

    /**
     * Returns a review based off the username of the user
     * @param username
     * @return the Review with the corresponding username
     */
    public List<Reviews> getReviewByUname(String username) {

        List<Reviews> temp = new ArrayList<>();

        for (Reviews r : reviewList) {
            if (r.getUserName().equals(username)) {
                temp.add(r);
            }
        }

        return temp;
    }

    /**
     * Returns the number of reviews that a restaurant has
     * @param restID
     * @return
     */
    public int getNumReviews(String restID) {

        int counter = 0;

        for (Reviews r : reviewList) {
            if (r.getID().equalsIgnoreCase(restID)) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Returns the average rating that a restaurant has
     * @param restID
     * @return
     */
    public double getReviewStats(String restID) {

        double avg;
        double total = 0.0;
        int counter = 0;

        for (Reviews r : reviewList) {
            if (r.getID().equals(restID)) {
                total += r.getNumStars();
                counter++;
            }
        }

        avg = (total / counter);

        return avg;
    }

    /**
     * Writes the new review to the reviews.txt file
     * @param reviews
     */
    public void writeReviewToFile(Reviews reviews) {

        File file = new File("reviews.txt");

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(reviews.getRestName() + "," + reviews.getDate() + "," + reviews.getUserName() + "," + reviews.getNumStars()
                        + "," + reviews.getReviewDescription() + "," + reviews.getID());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
