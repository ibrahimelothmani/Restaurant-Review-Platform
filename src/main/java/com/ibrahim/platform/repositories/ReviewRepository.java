package com.ibrahim.platform.repositories;

import com.ibrahim.platform.domain.entities.Review;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ElasticsearchRepository<Review, String> {
}
