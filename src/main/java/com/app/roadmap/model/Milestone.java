package com.app.roadmap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Instant timeStarted;
    private Instant timeFinished;
    private Integer progressPercent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Roadmap roadmap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Milestone milestone = (Milestone) o;
        return getId() != null && Objects.equals(getId(), milestone.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
