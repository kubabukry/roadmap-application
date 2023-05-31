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
@RequiredArgsConstructor
@ToString
public class TopicDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String link;
    private Instant dateCreated;
    private Instant dateFinished;
    private Integer generalRating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "topicDetail",
            orphanRemoval = true)
    @ToString.Exclude
    private List<Topic> topic;

    @ManyToMany(mappedBy = "topicDetailSet")
    @ToString.Exclude
    private Set<MilestoneDetail> milestoneDetailSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TopicDetail that = (TopicDetail) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
