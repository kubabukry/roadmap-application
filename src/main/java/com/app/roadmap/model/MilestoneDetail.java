package com.app.roadmap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MilestoneDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Category category;

    @ManyToMany(mappedBy = "milestoneDetailSet")
    @ToString.Exclude
    private Set<RoadmapDetail> roadmapDetailSet;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "topic_detail_milestone_detail",
            joinColumns = @JoinColumn(name = "topic_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "milestone_detail_id"))
    @ToString.Exclude
    private Set<TopicDetail> topicDetailSet;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MilestoneDetail that = (MilestoneDetail) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
