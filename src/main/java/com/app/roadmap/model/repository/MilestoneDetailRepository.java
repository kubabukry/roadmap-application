package com.app.roadmap.model.repository;

import com.app.roadmap.model.MilestoneDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneDetailRepository extends JpaRepository<MilestoneDetail, Long> {
}
