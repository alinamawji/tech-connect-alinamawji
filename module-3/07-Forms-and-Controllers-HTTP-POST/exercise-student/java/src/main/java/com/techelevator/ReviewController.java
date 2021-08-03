package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String displayHomePageWithReviews(ModelMap modelHolder) {
        List<Review> reviewList = reviewDao.getAllReviews();
        modelHolder.put("reviews", reviewList);
        return "home";
    }

    @RequestMapping(value="/newReview", method = RequestMethod.GET)
    public String displayCreateNewReviewPage() {
        return "newReview";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String createNewReview(String username, int rating, String title, String content, ModelMap modelHolder) {
        Review newReview = new Review();
        newReview.setUsername(username);
        newReview.setRating(rating);
        newReview.setTitle(title);
        newReview.setText(content);
        newReview.setDateSubmitted(LocalDateTime.now());
        reviewDao.save(newReview);
        List<Review> updatedReviews = reviewDao.getAllReviews();
        modelHolder.put("reviews", updatedReviews);
        return "home";
    }
}