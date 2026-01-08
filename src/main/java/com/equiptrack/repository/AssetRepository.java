package com.equiptrack.repository;

import com.equiptrack.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    // Spring Data JPA automatically writes the SQL for this method name!
    // It translates to: SELECT * FROM assets WHERE serial_number LIKE %keyword%
    List<Asset> findBySerialNumberContainingIgnoreCase(String keyword);
}