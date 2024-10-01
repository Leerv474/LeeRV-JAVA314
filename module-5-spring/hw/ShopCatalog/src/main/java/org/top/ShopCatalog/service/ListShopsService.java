package org.top.ShopCatalog.service;

import lombok.RequiredArgsConstructor;
import org.top.ShopCatalog.dao.ShopDao;
import org.top.ShopCatalog.model.Shop;

import java.util.List;

@RequiredArgsConstructor
public class ListShopsService {
    private final ShopDao shopDao;

    public List<Shop> listShops() {
        return shopDao.getShopList();
    }
}