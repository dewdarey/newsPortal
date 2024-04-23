package kz.springproject.phoenix.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }
}
