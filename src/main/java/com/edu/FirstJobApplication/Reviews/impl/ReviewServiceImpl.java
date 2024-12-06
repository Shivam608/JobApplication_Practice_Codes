package com.edu.FirstJobApplication.Reviews.impl;

import com.edu.FirstJobApplication.Reviews.ReviewService;
import com.edu.FirstJobApplication.Reviews.Reviews;
import com.edu.FirstJobApplication.Reviews.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewsRepository reviewsRepository;

    public ReviewServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> getAllReviews(long companyId) {
        return reviewsRepository.findByCompany_companyId(companyId);
    }
}
