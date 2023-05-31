package com.app.roadmap.model.repository;

import com.app.roadmap.model.RoadmapDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadmapDetailRepository extends JpaRepository<RoadmapDetail, Long> {
}
