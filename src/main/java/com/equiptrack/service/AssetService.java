package com.equiptrack.service;

import com.equiptrack.model.Asset;
import com.equiptrack.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public void saveAsset(Asset asset) {
        // Business Logic: Force serial numbers to uppercase for consistency
        if (asset.getSerialNumber() != null) {
            asset.setSerialNumber(asset.getSerialNumber().toUpperCase());
        }
        assetRepository.save(asset);
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found for id :: " + id));
    }

    public void deleteAssetById(Long id) {
        assetRepository.deleteById(id);
    }
}