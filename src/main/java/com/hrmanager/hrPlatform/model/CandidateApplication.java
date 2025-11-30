package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CandidateApplication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost job;

    private String name;
    private String email;
    private String resumePath;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        New,
        Interviewed,
        Hired,
        Rejected
    }
}
