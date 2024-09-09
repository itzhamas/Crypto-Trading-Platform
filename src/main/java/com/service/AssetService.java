package com.service;

import com.modal.Asset;
import com.modal.Coin;
import com.modal.User;

import java.util.List;

public interface AssetService {

    Asset createAsset (User user, Coin coin, double quantity);
    Asset getAssetById(Long assetId) throws Exception;
    Asset getAssetByUserIdAndId(Long userId, Long assetId);
    List<Asset> getUsersAssets (Long userId);
    Asset updateAsset (Long assetId, double quantity) throws Exception;
    Asset findAssetByUserIdAndCoinId (Long userId, String coinId);

    void deleteAsset (Long assetId);



}