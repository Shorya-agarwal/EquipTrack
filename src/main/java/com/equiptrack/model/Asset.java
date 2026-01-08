package com.equiptrack.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private AssetStatus status = AssetStatus.AVAILABLE; // Default to AVAILABLE

    private LocalDate dateAcquired;

    // This runs before the data is saved to DB
    @PrePersist
    public void prePersist() {
        if (dateAcquired == null) {
            dateAcquired = LocalDate.now(); // Auto-set today's date
        }
    }
}