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
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean idDone;
    private Instant dateStarted;
    private Instant dateFinished;
    private Integer userRating;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Milestone milestone;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private TopicDetail topicDetail;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Topic topic = (Topic) o;
        return getId() != null && Objects.equals(getId(), topic.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
