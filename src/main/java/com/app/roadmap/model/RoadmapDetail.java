package com.app.roadmap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoadmapDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Instant dateCreated;
    private Integer generalRating;
    private Integer averageCompletionDays;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "roadmapDetail")
    @ToString.Exclude
    private List<Roadmap> roadmapList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "milestone_detail_roadmap_detail",
            joinColumns = @JoinColumn(name = "milestone_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "roadmap_detail_id"))
    @ToString.Exclude
    private Set<MilestoneDetail> milestoneDetailSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoadmapDetail that = (RoadmapDetail) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
