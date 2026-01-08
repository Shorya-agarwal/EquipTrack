package com.equiptrack.controller;

import com.equiptrack.model.Asset;
import com.equiptrack.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssetController {

    @Autowired
    private AssetService assetService;

    // Display list of assets
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAssets", assetService.getAllAssets());
        return "index"; // Corresponds to index.html
    }

    // Show the form to add a new asset
    @GetMapping("/showNewAssetForm")
    public String showNewAssetForm(Model model) {
        Asset asset = new Asset();
        model.addAttribute("asset", asset);
        return "new_asset"; // Corresponds to new_asset.html
    }

    // Save the asset to the database
    @PostMapping("/saveAsset")
    public String saveAsset(@ModelAttribute("asset") Asset asset) {
        assetService.saveAsset(asset);
        return "redirect:/";
    }

    // Delete an asset
    @GetMapping("/deleteAsset/{id}")
    public String deleteAsset(@PathVariable(value = "id") Long id) {
        this.assetService.deleteAssetById(id);
        return "redirect:/";
    }
}