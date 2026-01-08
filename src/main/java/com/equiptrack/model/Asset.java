package com.equiptrack.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
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
    private AssetStatus status = AssetStatus.AVAILABLE;

    private LocalDate dateAcquired;

    @PrePersist
    public void prePersist() {
        if (dateAcquired == null) {
            dateAcquired = LocalDate.now();
        }
    }

    // --- MANUAL GETTERS AND SETTERS (Fixes your error) ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public AssetStatus getStatus() { return status; }
    public void setStatus(AssetStatus status) { this.status = status; }

    public LocalDate getDateAcquired() { return dateAcquired; }
    public void setDateAcquired(LocalDate dateAcquired) { this.dateAcquired = dateAcquired; }
}