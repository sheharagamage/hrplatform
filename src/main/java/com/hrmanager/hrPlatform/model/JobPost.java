package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "JobPost")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        Open,
        Closed
    }
}
