package com.app.roadmap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Instant timeStarted;
    private Instant timeFinished;
    private Integer progressPercent;
    private Integer userRating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private RoadmapDetail roadmapDetail;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person person;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "roadmap")
    private List<Milestone> milestoneList;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Roadmap roadmap = (Roadmap) o;
        return getId() != null && Objects.equals(getId(), roadmap.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
