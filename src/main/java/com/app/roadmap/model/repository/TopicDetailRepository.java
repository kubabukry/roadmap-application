package com.app.roadmap.model.repository;

import com.app.roadmap.model.TopicDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDetailRepository extends JpaRepository<TopicDetail, Long> {
}
