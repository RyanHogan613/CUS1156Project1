import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ReviewListTest {

    Reviews review;
    ReviewList reviewList = new ReviewList();
    LocalDate date = LocalDate.now();

    @Before
    public void setUp() throws Exception {
        reviewList.add(review = new Reviews("Ryan's Pizza", date, "ryanH",
                4, "good food", "1232"));
    }

    @Test
    public void getReviewByRestID() throws Exception {
        List<Reviews> compare = reviewList.getReviewByRestID("1232");
        assertEquals("1232", compare.get(0).getID());
    }

    @Test
    public void getReviewByUname() throws Exception {
        List<Reviews> compare = reviewList.getReviewByUname("ryanH");
        assertEquals("ryanH", compare.get(0).userName);
    }

    @Test
    public void getNumReviews() throws Exception {
        assertEquals(1, reviewList.getNumReviews("1232"));
    }
}
