import java.time.LocalDate;

/**
 * Reviews is the wrapper class that handles the attributes for the reviews
 * in the list of reviews.
 */
public class Reviews {

    public int reviewNum;
    public LocalDate date;
    public String userName;
    public int numStars;
    public String reviewDescription;
    public String restName;
    public String restID;

    public Reviews(String rName, LocalDate date, String user, int stars, String reviewDescr, String rID) {
        this.date = date;
        this.userName = user;
        this.numStars = stars;
        this.reviewDescription = reviewDescr;
        this.restName = rName;
        this.restID = rID;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public void setID(String id) {
        this.restID = id;
    }

    public String getID() {
        return restID;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setRestName(String rName) {
        this.restName = rName;
    }

    public String getRestName() {
        return  restName;
    }

    @Override
    public String toString() {
        return "  Restaurant Name: " + restName + "\t" +
                " Date: " + date + "\t" +
                " Username: " + userName + "\t" +
                " Stars: " + numStars + "\t" +
                " Review Description: " + reviewDescription;
    }
}
