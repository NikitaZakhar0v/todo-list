package ru.zakharov.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task", schema = "todo")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'PAUSED'")
    @Enumerated(EnumType.STRING)
    private Status status;
}
